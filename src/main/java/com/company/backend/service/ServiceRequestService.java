package com.company.backend.service;

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

    public ServiceRequestService(ServiceRequestRepository serviceRequestRepository, ServiceRequestMapper serviceRequestMapper) {
        this.serviceRequestRepository = serviceRequestRepository;
        this.serviceRequestMapper = serviceRequestMapper;
    }

    public List<ServiceRequestDTO> getAllServiceRequests() {
        return serviceRequestRepository.findAll().stream()
                .map(serviceRequestMapper::convertServiceRequestToDTO)
                .collect(Collectors.toList());
    }

    public ServiceRequestDTO getServiceRequestById(Long id) {
        ServiceRequest serviceRequest = serviceRequestRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        return serviceRequestMapper.convertServiceRequestToDTO(serviceRequest);
    }
}
