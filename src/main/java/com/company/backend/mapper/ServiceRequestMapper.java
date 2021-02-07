package com.company.backend.mapper;

import com.company.backend.dto.serviceRequest.NewServiceRequestDTO;
import com.company.backend.dto.serviceRequest.ServiceRequestDTO;
import com.company.backend.dto.serviceRequest.UpdateServiceRequestDTO;
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

    public ServiceRequest convertNewServiceRequestDtoToEntity(NewServiceRequestDTO newServiceRequestDTO) {
        return modelMapper.map(newServiceRequestDTO, ServiceRequest.class);
    }

    public ServiceRequest convertUpdateServiceRequestDtoToEntity(UpdateServiceRequestDTO updateServiceRequestDTO) {
        return modelMapper.map(updateServiceRequestDTO, ServiceRequest.class);
    }
}
