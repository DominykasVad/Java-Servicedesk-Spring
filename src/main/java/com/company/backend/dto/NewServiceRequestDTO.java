package com.company.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class NewServiceRequestDTO {

    private Long id;

    @NotEmpty
    private String summary;

    @NotEmpty
    private String description;

    private Long companyId;

}
