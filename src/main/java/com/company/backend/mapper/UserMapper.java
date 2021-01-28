package com.company.backend.mapper;

import com.company.backend.dto.UserDTO;
import com.company.backend.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO convertUserEntityToDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public User convertUserDtoToEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}
