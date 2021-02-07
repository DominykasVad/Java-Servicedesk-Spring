package com.company.backend.dto.user;

import com.company.backend.dto.serviceRequest.UserServiceRequestDTO;
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

    private String name;

    private String surname;

    private String email;

    private String phone;

    private String organizationalUnitName;

    private Set<RoleDTO> roles;

    private Set<UserServiceRequestDTO> serviceRequests;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
