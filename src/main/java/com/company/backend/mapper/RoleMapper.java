package com.company.backend.mapper;

import com.company.backend.dto.user.RoleDTO;
import com.company.backend.entity.Role;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    @Autowired
    private ModelMapper modelMapper;

    public RoleDTO convertRoleEntityToDTO(Role role) {
        return modelMapper.map(role, RoleDTO.class);
    }

}
