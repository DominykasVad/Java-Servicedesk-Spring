package com.company.backend.controller;

import com.company.backend.dto.configurationItem.ConfigurationItemDTO;
import com.company.backend.dto.configurationItem.ConfigurationItemLinkPOJO;
import com.company.backend.dto.configurationItem.NewConfigurationItemDTO;
import com.company.backend.dto.configurationItem.UpdateConfigurationItemDTO;
import com.company.backend.service.ConfigurationItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/ci")
public class ConfigurationItemController {

    private final ConfigurationItemService configurationItemService;

    public ConfigurationItemController(ConfigurationItemService configurationItemService) {
        this.configurationItemService = configurationItemService;
    }

    @GetMapping
    public Page<ConfigurationItemDTO> getConfigurationItems(@RequestParam(required = false, name = "serviceRequestId") Optional<Long> serviceRequestIdParam, Pageable pageable) {
        if (serviceRequestIdParam.isPresent()) {
            return configurationItemService.getConfigurationItemsByServiceRequestId(serviceRequestIdParam.get(), pageable);
        }
        return configurationItemService.getAllConfigurationItems(pageable);
    }

    @GetMapping("/{id}")
    public ConfigurationItemDTO getConfigurationItem(@PathVariable Long id) {
        return configurationItemService.getSingleConfigurationItem(id);
    }

    @PostMapping
    public ResponseEntity<ConfigurationItemDTO> addServiceRequest(@RequestBody @Valid NewConfigurationItemDTO newConfigurationItemDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(configurationItemService.createConfigurationItem(newConfigurationItemDTO));
    }

    @PostMapping("/link-ci")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void linkConfigurationItemToServiceRequest(@RequestBody @Valid ConfigurationItemLinkPOJO configurationItemLinkPOJO) {
        configurationItemService.linkConfigurationItemToServiceRequest(configurationItemLinkPOJO);
    }

    @PostMapping("/unlink-ci")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void unlinkConfigurationItemToServiceRequest(@RequestBody @Valid ConfigurationItemLinkPOJO configurationItemLinkPOJO) {
        configurationItemService.unlinkConfigurationItemToServiceRequest(configurationItemLinkPOJO);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ConfigurationItemDTO updateConfigurationItem(@RequestBody @Valid UpdateConfigurationItemDTO updateConfigurationItemDTO) {
        return configurationItemService.updateConfigurationItem(updateConfigurationItemDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConfigurationItem(@PathVariable Long id) {
        configurationItemService.deleteConfigurationItem(id);
    }
}
