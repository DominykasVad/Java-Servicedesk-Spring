package com.company.backend.dto.location;

import com.company.backend.dto.organizationalUnit.OrganizationalUnitDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class LocationDTO {

    private Long id;

    private OrganizationalUnitDTO organizationalUnit;

    private String name;

}
