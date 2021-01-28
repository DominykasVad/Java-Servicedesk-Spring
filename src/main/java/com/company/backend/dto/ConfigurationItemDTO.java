package com.company.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ConfigurationItemDTO {

    private Long id;

    private String name;

    private String description;

    private String serialNumber;

    private String inventoryNumber;

    private String model;

    private String vendor;

    private OrganizationalUnitDTO organizationalUnit;

    private StatusDTO status;

    private LocationDTO currentLocation;

}
