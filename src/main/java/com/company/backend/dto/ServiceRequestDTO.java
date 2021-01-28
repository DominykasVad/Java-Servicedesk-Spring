package com.company.backend.dto;

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

    private UserDTO owner;

    private CompanyDTO company;

    private UserDTO reportedBy;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
