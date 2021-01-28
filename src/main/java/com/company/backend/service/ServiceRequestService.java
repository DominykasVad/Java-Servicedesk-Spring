package com.company.backend.service;

import com.company.backend.dto.NewServiceRequestDTO;
import com.company.backend.dto.ServiceRequestDTO;
import com.company.backend.entity.ServiceRequest;
import com.company.backend.exeption.EntityNotFoundException;
import com.company.backend.mapper.ServiceRequestMapper;
import com.company.backend.repository.ServiceRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<ServiceRequestDTO> getAllServiceRequests() {
        return serviceRequestRepository.findAll().stream()
                .map(serviceRequestMapper::convertServiceRequestEntityToDTO)
                .collect(Collectors.toList());
    }

    public ServiceRequestDTO getServiceRequestById(Long id) {
        ServiceRequest serviceRequest = serviceRequestRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        return serviceRequestMapper.convertServiceRequestEntityToDTO(serviceRequest);
    }

    public NewServiceRequestDTO createServiceRequest(NewServiceRequestDTO newServiceRequestDTO) {
        ServiceRequest serviceRequest = serviceRequestMapper.convertNewServiceRequestDtoToEntity(newServiceRequestDTO);
        // TODO: 1/28/21 Set logged in User in reportedBy field
        serviceRequest.setReportedBy(userService.getUserEntityById(1L));
        ServiceRequest savedServiceRequest = serviceRequestRepository.save(serviceRequest);
        newServiceRequestDTO.setId(savedServiceRequest.getId());
        return newServiceRequestDTO;
    }

}
