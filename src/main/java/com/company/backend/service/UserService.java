package com.company.backend.service;

import com.company.backend.dto.UserDTO;
import com.company.backend.entity.User;
import com.company.backend.exeption.EntityNotFoundException;
import com.company.backend.mapper.UserMapper;
import com.company.backend.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public User getUserEntityById(Long id) {
        return userRepository.findUserByIdWithRole(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    public UserDTO getUserDtoById(Long id) {
        User user = userRepository.findUserByIdWithRole(id).orElseThrow(() -> new EntityNotFoundException(id));
        return userMapper.convertUserEntityToDTO(user);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAllUsersWithRole().stream()
                .map(userMapper::convertUserEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsernameWithRole(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with username: %s Not found", username)));
    }
}
