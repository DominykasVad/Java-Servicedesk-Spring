package com.company.backend.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// TODO: 2/7/21 Email, phone validation
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UpdateUserDTO {

    private Long id;

    private String name;

    private String surname;

    private String email;

    private String phone;

}
