package com.company.backend.service;

import com.company.backend.dto.serviceRequest.NewServiceRequestDTO;
import com.company.backend.dto.serviceRequest.ServiceRequestDTO;
import com.company.backend.dto.serviceRequest.UpdateServiceRequestDTO;
import com.company.backend.entity.ServiceRequest;
import com.company.backend.exeption.EntityNotFoundException;
import com.company.backend.mapper.ServiceRequestMapper;
import com.company.backend.repository.ServiceRequestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ServiceRequestService {

    private ServiceRequestRepository serviceRequestRepository;
    private ServiceRequestMapper serviceRequestMapper;
    private UserService userService;

    public ServiceRequestService(ServiceRequestRepository serviceRequestRepository, ServiceRequestMapper serviceRequestMapper, UserService userService) {
        this.serviceRequestRepository = serviceRequestRepository;
        this.serviceRequestMapper = serviceRequestMapper;
        this.userService = userService;
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

    public ServiceRequestDTO createServiceRequest(NewServiceRequestDTO newServiceRequestDTO) {
        ServiceRequest serviceRequest = serviceRequestMapper.convertNewServiceRequestDtoToEntity(newServiceRequestDTO);
        // TODO: 1/28/21 Set logged in User in reportedBy field
        serviceRequest.setReportedBy(userService.getUserEntityById(1L));
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
}
