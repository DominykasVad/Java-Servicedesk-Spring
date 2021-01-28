package com.company.backend.mapper;

import com.company.backend.dto.ServiceRequestDTO;
import com.company.backend.entity.ServiceRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceRequestMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ServiceRequestDTO convertServiceRequestEntityToDTO(ServiceRequest serviceRequest) {
        return modelMapper.map(serviceRequest, ServiceRequestDTO.class);
    }

    public ServiceRequest convertServiceRequestDtoToEntity(ServiceRequestDTO serviceRequestDTO) {
        return modelMapper.map(serviceRequestDTO, ServiceRequest.class);
    }
}
