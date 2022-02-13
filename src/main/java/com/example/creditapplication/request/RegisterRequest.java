package com.example.creditapplication.request;

import com.example.creditapplication.service.user.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RegisterRequest {
    @NotBlank
    private String userName;
    @NotBlank
    private String password;

    public User convertToUser() {
        return User.builder()
                .userName(userName)
                .password(password)
                .build();
    }
}
