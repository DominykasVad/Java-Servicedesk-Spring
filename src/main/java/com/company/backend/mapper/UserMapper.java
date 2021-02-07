package com.company.backend.mapper;

import com.company.backend.dto.user.NewUserDTO;
import com.company.backend.dto.user.UpdateUserDTO;
import com.company.backend.dto.user.UserDTO;
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

    public User convertNewUserDtoToEntity(NewUserDTO newUserDTO) {
        return modelMapper.map(newUserDTO, User.class);
    }

    public User convertUpdateUserDtoToEntity(UpdateUserDTO updateUserDTO) {
        return modelMapper.map(updateUserDTO, User.class);
    }
}
