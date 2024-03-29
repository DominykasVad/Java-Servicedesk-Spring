package com.company.backend.dto.serviceRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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

    @NotNull
    private Long serviceRequestStatusId;

    private Long organizationalUnitId;

}
