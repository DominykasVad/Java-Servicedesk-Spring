package com.company.backend.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

// TODO: 2/7/21 Email, phone validation
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class NewUserDTO {

    @NotEmpty
    private String username;

    // TODO: 2/7/21 password validation
    @NotEmpty
    private String password;

    @NotEmpty
    private String name;

    @NotEmpty
    private String surname;

    @NotEmpty
    private String email;

    private String phone;

    private String organizationalUnitId;

    @NotNull
    private Long role;
}
