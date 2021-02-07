package com.company.backend.dto.serviceRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ServiceRequestOwnershipPOJO {

    @NotNull
    private Long id;

}
