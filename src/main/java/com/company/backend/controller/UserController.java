package com.company.backend.controller;

import com.company.backend.dto.UserDTO;
import com.company.backend.entity.User;
import com.company.backend.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

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
    public UserDTO user(@AuthenticationPrincipal User user) {
        return userService.getUserDtoById(user.getId());
    }
}
