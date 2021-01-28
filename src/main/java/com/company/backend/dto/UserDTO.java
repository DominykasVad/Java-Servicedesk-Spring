package com.company.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDTO {

    private Long id;

    private String username;

    private String password;

    private String name;

    private String surname;

    private String email;

    private String phone;

    private String companyName;

    private Set<UserServiceRequestDTO> serviceRequests;

    private Set<UserServiceRequestDTO> reportedServiceRequests;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
