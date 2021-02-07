package com.company.backend.dto.serviceRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ServiceRequestDTO {

    private Long id;

    private String summary;

    private String description;

    private String ownerUsername;

    private String organizationalUnitName;

    private String reportedByUsername;

    private Long serviceRequestStatusId;

    private String serviceRequestStatusName;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
