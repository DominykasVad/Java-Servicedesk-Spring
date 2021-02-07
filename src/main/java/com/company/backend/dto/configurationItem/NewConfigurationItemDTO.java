package com.company.backend.dto.configurationItem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class NewConfigurationItemDTO {

    private Long id;

    @NotEmpty
    private String name;

    private String description;

    @NotEmpty
    private String serialNumber;

    private String inventoryNumber;

    private String model;

    private String vendor;

}
