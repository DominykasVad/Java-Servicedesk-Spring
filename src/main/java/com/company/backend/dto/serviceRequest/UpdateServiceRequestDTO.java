package com.company.backend.dto.serviceRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UpdateServiceRequestDTO {

    private Long id;

    @NotEmpty
    private String summary;

    @NotEmpty
    private String description;

    private String organizationalUnitId;

}
