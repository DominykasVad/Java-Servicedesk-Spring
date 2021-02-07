package com.company.backend.service;

import com.company.backend.dto.user.*;
import com.company.backend.entity.Role;
import com.company.backend.entity.User;
import com.company.backend.exeption.EntityNotFoundException;
import com.company.backend.mapper.RoleMapper;
import com.company.backend.mapper.UserMapper;
import com.company.backend.repository.RoleRepository;
import com.company.backend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private PasswordEncoder passwordEncoder;

    private RoleRepository roleRepository;
    private RoleMapper roleMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder, RoleRepository roleRepository, RoleMapper roleMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    public User getUserEntityById(Long id) {
        return userRepository.findUserByIdWithRole(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    public UserDTO getUserDtoById(Long id) {
        User user = userRepository.findUserByIdWithRole(id).orElseThrow(() -> new EntityNotFoundException(id));
        return userMapper.convertUserEntityToDTO(user);
    }

    public UserLoginDTO getUserLoginDtoById(Long id) {
        User user = userRepository.findUserByIdWithRole(id).orElseThrow(() -> new EntityNotFoundException(id));
        return userMapper.convertUserEntityToUserLoginDTO(user);
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

    public void addRoleToUser(UserRoleLinkPOJO userRoleLinkPOJO) {
        Long userId = userRoleLinkPOJO.getId();
        Long roleId = userRoleLinkPOJO.getRoleId();
        User user = userRepository.findUserByIdWithRole(userId).orElseThrow(() -> new EntityNotFoundException(userId));
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new EntityNotFoundException(roleId));
        user.getRoles().add(role);
        userRepository.save(user);
    }

    public void removeRoleFromUser(UserRoleLinkPOJO userRoleLinkPOJO) {
        Long userId = userRoleLinkPOJO.getId();
        Long roleId = userRoleLinkPOJO.getRoleId();
        User user = userRepository.findUserByIdWithRole(userId).orElseThrow(() -> new EntityNotFoundException(userId));
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new EntityNotFoundException(roleId));
        user.getRoles().remove(role);
        userRepository.save(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public UserDTO createUser(NewUserDTO newUserDTO) {
        User newUser = userMapper.convertNewUserDtoToEntity(newUserDTO);
        Role role = roleRepository.findById(newUserDTO.getRole()).orElseThrow(() -> new EntityNotFoundException(newUserDTO.getRole()));
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        newUser.setRoles(Set.of(role));
        User savedUser = userRepository.save(newUser);
        return userMapper.convertUserEntityToDTO(savedUser);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public UserDTO updateUser(UpdateUserDTO updateUserDTO) {
        User updateServiceRequest = userMapper.convertUpdateUserDtoToEntity(updateUserDTO);
        User savedServiceRequest = userRepository.save(updateServiceRequest);
        return userMapper.convertUserEntityToDTO(savedServiceRequest);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(Long id) {
        log.warn(String.format("User ID: %s Deleted User ID: %s", 1, id));
        userRepository.deleteById(id);
    }

    public List<RoleDTO> getAllRoles() {
        return roleRepository.findAll().stream()
                .map(roleMapper::convertRoleEntityToDTO)
                .collect(Collectors.toList());
    }
}
