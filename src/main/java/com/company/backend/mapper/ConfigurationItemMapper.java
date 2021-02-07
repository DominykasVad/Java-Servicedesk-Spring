package com.company.backend.mapper;

import com.company.backend.dto.configurationItem.ConfigurationItemDTO;
import com.company.backend.dto.configurationItem.NewConfigurationItemDTO;
import com.company.backend.dto.configurationItem.UpdateConfigurationItemDTO;
import com.company.backend.entity.ConfigurationItem;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfigurationItemMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ConfigurationItemDTO convertConfigurationItemEntityToDTO(ConfigurationItem configurationItem) {
        return modelMapper.map(configurationItem, ConfigurationItemDTO.class);
    }

    public ConfigurationItem convertConfigurationItemDtoToEntity(ConfigurationItemDTO configurationItemDTO) {
        return modelMapper.map(configurationItemDTO, ConfigurationItem.class);
    }

    public ConfigurationItem convertNewConfigurationItemDtoToEntity(NewConfigurationItemDTO newConfigurationItemDTO) {
        return modelMapper.map(newConfigurationItemDTO, ConfigurationItem.class);
    }

    public ConfigurationItem convertUpdateConfigurationItemDtoToEntity(UpdateConfigurationItemDTO updateConfigurationItemDTO) {
        return modelMapper.map(updateConfigurationItemDTO, ConfigurationItem.class);
    }
}

