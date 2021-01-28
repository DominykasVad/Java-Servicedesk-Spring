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
public class UserDTO {

    private Long id;

    private String username;

    private String password;

    private String name;

    private String surname;

    private String email;

    private String phone;

    private CompanyDTO company;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
