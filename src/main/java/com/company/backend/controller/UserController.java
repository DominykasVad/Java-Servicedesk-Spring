package com.company.backend.controller;

import com.company.backend.dto.user.*;
import com.company.backend.entity.User;
import com.company.backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Long id) {
        return userService.getUserDtoById(id);
    }

    @PostMapping("/login")
    public UserLoginDTO user(@AuthenticationPrincipal User user) {
        return userService.getUserLoginDtoById(user.getId());
    }

    @PostMapping("/add-role")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addRoleToUser(@RequestBody @Valid UserRoleLinkPOJO userRoleLinkPOJO) {
        userService.addRoleToUser(userRoleLinkPOJO);
    }

    @PostMapping("/remove-role")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeRoleFromUser(@RequestBody @Valid UserRoleLinkPOJO userRoleLinkPOJO) {
        userService.removeRoleFromUser(userRoleLinkPOJO);
    }

    @PostMapping
    public ResponseEntity<UserDTO> addUser(@RequestBody @Valid NewUserDTO newUserDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.createUser(newUserDTO));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UserDTO updateUser(@RequestBody @Valid UpdateUserDTO updateUserDTO) {
        return userService.updateUser(updateUserDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/user-roles")
    public List<RoleDTO> getAllRoles() {
        return userService.getAllRoles();
    }
}
