package com.company.backend.controller;

import com.company.backend.dto.serviceRequest.UpdateServiceRequestDTO;
import com.company.backend.dto.serviceRequest.NewServiceRequestDTO;
import com.company.backend.dto.serviceRequest.ServiceRequestDTO;
import com.company.backend.service.ServiceRequestService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/sr")
public class ServiceRequestController {

    private ServiceRequestService serviceRequestService;

    public ServiceRequestController(ServiceRequestService serviceRequestService) {
        this.serviceRequestService = serviceRequestService;
    }

    @GetMapping
    public Page<ServiceRequestDTO> getAllServiceRequests(@RequestParam(required = false, name = "ownerId") Optional<Long> ownerId, Pageable pageable) {
        if (ownerId.isPresent()) {
            return serviceRequestService.getAllServiceRequestsByOwnerId(ownerId.get(), pageable);
        }
        return serviceRequestService.getAllServiceRequests(pageable);
    }

    @GetMapping("/{id}")
    public ServiceRequestDTO getServiceRequest(@PathVariable Long id) {
        return serviceRequestService.getServiceRequestById(id);
    }

    @PostMapping
    public ResponseEntity<ServiceRequestDTO> addServiceRequest(@RequestBody @Valid NewServiceRequestDTO newServiceRequestDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(serviceRequestService.createServiceRequest(newServiceRequestDTO));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ServiceRequestDTO updateServiceRequest(@RequestBody @Valid UpdateServiceRequestDTO updateServiceRequestDTO) {
        return serviceRequestService.updateServiceRequest(updateServiceRequestDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteServiceRequest(@PathVariable Long id) {
        serviceRequestService.deleteServiceRequest(id);
    }

}
