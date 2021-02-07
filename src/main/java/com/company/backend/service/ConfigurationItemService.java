package com.company.backend.service;

import com.company.backend.dto.configurationItem.ConfigurationItemDTO;
import com.company.backend.dto.configurationItem.ConfigurationItemLinkPOJO;
import com.company.backend.dto.configurationItem.NewConfigurationItemDTO;
import com.company.backend.dto.configurationItem.UpdateConfigurationItemDTO;
import com.company.backend.entity.ConfigurationItem;
import com.company.backend.entity.ServiceRequest;
import com.company.backend.exeption.EntityNotFoundException;
import com.company.backend.mapper.ConfigurationItemMapper;
import com.company.backend.repository.ConfigurationItemRepository;
import com.company.backend.repository.ServiceRequestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConfigurationItemService {

    private final ConfigurationItemRepository configurationItemRepository;
    private final ConfigurationItemMapper configurationItemMapper;

    private final ServiceRequestRepository serviceRequestRepository;

    public ConfigurationItemService(ConfigurationItemRepository configurationItemRepository, ConfigurationItemMapper configurationItemMapper, ServiceRequestRepository serviceRequestRepository) {
        this.configurationItemRepository = configurationItemRepository;
        this.configurationItemMapper = configurationItemMapper;
        this.serviceRequestRepository = serviceRequestRepository;
    }

    public Page<ConfigurationItemDTO> getAllConfigurationItems(Pageable pageable) {
        return configurationItemRepository.findAll(pageable)
                .map(configurationItemMapper::convertConfigurationItemEntityToDTO);
    }

    public ConfigurationItemDTO getSingleConfigurationItem(Long id) {
        ConfigurationItem configurationItem = configurationItemRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        return configurationItemMapper.convertConfigurationItemEntityToDTO(configurationItem);
    }

    public Page<ConfigurationItemDTO> getConfigurationItemsByServiceRequestId(Long serviceRequestId, Pageable pageable) {
        return configurationItemRepository.findAllConfigurationItemsByServiceRequestId(serviceRequestId, pageable)
                .map(configurationItemMapper::convertConfigurationItemEntityToDTO);
    }

    public ConfigurationItemDTO createConfigurationItem(NewConfigurationItemDTO newConfigurationItemDTO) {
        ConfigurationItem newConfigurationItem = configurationItemMapper.convertNewConfigurationItemDtoToEntity(newConfigurationItemDTO);
        ConfigurationItem savedConfigurationItem = configurationItemRepository.save(newConfigurationItem);
        return configurationItemMapper.convertConfigurationItemEntityToDTO(savedConfigurationItem);
    }

    // TODO: 2/6/21 Merge linker methods
    public void linkConfigurationItemToServiceRequest(ConfigurationItemLinkPOJO configurationItemLinkPOJO) {
        Long configurationItemId = configurationItemLinkPOJO.getId();
        Long serviceRequestId = configurationItemLinkPOJO.getServiceRequestId();
        ConfigurationItem configurationItem = configurationItemRepository.findById(configurationItemId).orElseThrow(() -> new EntityNotFoundException(configurationItemId));
        ServiceRequest serviceRequest = serviceRequestRepository.findById(serviceRequestId).orElseThrow(() -> new EntityNotFoundException(serviceRequestId));
        configurationItem.getServiceRequests().add(serviceRequest);
        configurationItemRepository.save(configurationItem);
    }

    public void unlinkConfigurationItemToServiceRequest(ConfigurationItemLinkPOJO configurationItemLinkPOJO) {
        Long configurationItemId = configurationItemLinkPOJO.getId();
        Long serviceRequestId = configurationItemLinkPOJO.getServiceRequestId();
        ConfigurationItem configurationItem = configurationItemRepository.findById(configurationItemId).orElseThrow(() -> new EntityNotFoundException(configurationItemId));
        ServiceRequest serviceRequest = serviceRequestRepository.findById(serviceRequestId).orElseThrow(() -> new EntityNotFoundException(serviceRequestId));
        configurationItem.getServiceRequests().remove(serviceRequest);
        configurationItemRepository.save(configurationItem);
    }

    public ConfigurationItemDTO updateConfigurationItem(UpdateConfigurationItemDTO updateConfigurationItemDTO) {
        ConfigurationItem updatedConfigurationItem = configurationItemMapper.convertUpdateConfigurationItemDtoToEntity(updateConfigurationItemDTO);
        ConfigurationItem savedConfigurationItem = configurationItemRepository.save(updatedConfigurationItem);
        return configurationItemMapper.convertConfigurationItemEntityToDTO(savedConfigurationItem);
    }

    public void deleteConfigurationItem(Long id) {
        log.warn(String.format("User ID: %s Deleted Configuration Item ID: %s", 1, id));
        configurationItemRepository.deleteById(id);
    }
}
