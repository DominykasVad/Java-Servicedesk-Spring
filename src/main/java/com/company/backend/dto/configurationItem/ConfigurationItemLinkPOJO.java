package com.company.backend.dto.configurationItem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ConfigurationItemLinkPOJO {

    @NotNull
    private Long id;

    @NotNull
    private Long serviceRequestId;

}
