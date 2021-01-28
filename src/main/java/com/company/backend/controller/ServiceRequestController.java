package com.company.backend.controller;

import com.company.backend.dto.NewServiceRequestDTO;
import com.company.backend.dto.ServiceRequestDTO;
import com.company.backend.service.ServiceRequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sr")
public class ServiceRequestController {

    private ServiceRequestService serviceRequestService;

    public ServiceRequestController(ServiceRequestService serviceRequestService) {
        this.serviceRequestService = serviceRequestService;
    }

    @GetMapping
    public List<ServiceRequestDTO> getAllServiceRequests() {
        return serviceRequestService.getAllServiceRequests();
    }

    @GetMapping("/{id}")
    public ServiceRequestDTO getServiceRequest(@PathVariable Long id) {
        return serviceRequestService.getServiceRequestById(id);
    }

    @PostMapping
    public ResponseEntity<NewServiceRequestDTO> addServiceRequest(@RequestBody @Valid NewServiceRequestDTO newServiceRequestDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(serviceRequestService.createServiceRequest(newServiceRequestDTO));
    }

}
