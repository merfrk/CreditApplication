package com.example.creditapplication.controller;

import com.example.creditapplication.request.RegisterRequest;
import com.example.creditapplication.service.user.User;
import com.example.creditapplication.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUserById(userId);
    }

    @PutMapping("/{userId}")
    public void updateUser(@PathVariable Long userId, @RequestBody RegisterRequest newUser) {
        User user = newUser.convertToUser();
        userService.updateUser(userId, user);
    }
}
