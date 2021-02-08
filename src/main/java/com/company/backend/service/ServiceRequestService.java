package com.company.backend.service;

import com.company.backend.dto.serviceRequest.NewServiceRequestDTO;
import com.company.backend.dto.serviceRequest.ServiceRequestDTO;
import com.company.backend.dto.serviceRequest.ServiceRequestOwnershipPOJO;
import com.company.backend.dto.serviceRequest.UpdateServiceRequestDTO;
import com.company.backend.entity.ServiceRequest;
import com.company.backend.entity.User;
import com.company.backend.exeption.EntityNotFoundException;
import com.company.backend.exeption.PrincipalNotFoundException;
import com.company.backend.mapper.ServiceRequestMapper;
import com.company.backend.repository.ServiceRequestRepository;
import com.company.backend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Slf4j
@Service
public class ServiceRequestService {

    private final ServiceRequestRepository serviceRequestRepository;
    private final ServiceRequestMapper serviceRequestMapper;

    private final UserRepository userRepository;

    public ServiceRequestService(ServiceRequestRepository serviceRequestRepository, ServiceRequestMapper serviceRequestMapper, UserRepository userRepository) {
        this.serviceRequestRepository = serviceRequestRepository;
        this.serviceRequestMapper = serviceRequestMapper;
        this.userRepository = userRepository;
    }

    public Page<ServiceRequestDTO> getAllServiceRequests(Pageable pageable) {
        return serviceRequestRepository.findAll(pageable)
                .map(serviceRequestMapper::convertServiceRequestEntityToDTO);
    }

    public Page<ServiceRequestDTO> getAllServiceRequestsByOwnerId(Long ownerId, Pageable pageable) {
        return serviceRequestRepository.findAllByOwnerId(ownerId, pageable)
                .map(serviceRequestMapper::convertServiceRequestEntityToDTO);
    }

    public ServiceRequestDTO getServiceRequestById(Long id) {
        ServiceRequest serviceRequest = serviceRequestRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        return serviceRequestMapper.convertServiceRequestEntityToDTO(serviceRequest);
    }

    public ServiceRequestDTO createServiceRequest(NewServiceRequestDTO newServiceRequestDTO, Principal principal) {
        ServiceRequest serviceRequest = serviceRequestMapper.convertNewServiceRequestDtoToEntity(newServiceRequestDTO);
        User user = userRepository.findUserByUsernameWithRole(principal.getName()).orElseThrow(() -> new PrincipalNotFoundException(principal));
        serviceRequest.setReportedBy(user);
        ServiceRequest savedServiceRequest = serviceRequestRepository.save(serviceRequest);
        return serviceRequestMapper.convertServiceRequestEntityToDTO(savedServiceRequest);
    }

    public ServiceRequestDTO updateServiceRequest(UpdateServiceRequestDTO updateServiceRequestDTO) {
        ServiceRequest updateServiceRequest = serviceRequestMapper.convertUpdateServiceRequestDtoToEntity(updateServiceRequestDTO);
        ServiceRequest savedServiceRequest = serviceRequestRepository.save(updateServiceRequest);
        return serviceRequestMapper.convertServiceRequestEntityToDTO(savedServiceRequest);
    }

    public void deleteServiceRequest(Long id) {
        log.warn(String.format("User ID: %s Deleted Service Request ID: %s", 1, id));
        serviceRequestRepository.deleteById(id);
    }

    public void serviceRequestTakeOwnership(ServiceRequestOwnershipPOJO serviceRequestOwnershipPOJO, Principal principal) {
        Long serviceRequestId = serviceRequestOwnershipPOJO.getId();
        User user = userRepository.findUserByUsernameWithRole(principal.getName()).orElseThrow(() -> new PrincipalNotFoundException(principal));
        ServiceRequest serviceRequest = serviceRequestRepository.findById(serviceRequestId).orElseThrow(() -> new EntityNotFoundException(serviceRequestId));
        serviceRequest.setOwner(user);
        serviceRequestRepository.save(serviceRequest);
    }
}
