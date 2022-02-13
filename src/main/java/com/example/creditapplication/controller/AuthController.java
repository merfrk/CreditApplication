package com.example.creditapplication.controller;

import com.example.creditapplication.request.LoginRequest;
import com.example.creditapplication.request.RegisterRequest;
import com.example.creditapplication.response.AuthResponse;
import com.example.creditapplication.security.JwtTokenProvider;
import com.example.creditapplication.service.user.User;
import com.example.creditapplication.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword());
        Authentication auth = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwtToken = jwtTokenProvider.generateJwtToken(auth);
        return "Bearer " + jwtToken;
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest registerRequest){
        AuthResponse authResponse = new AuthResponse();
        if (userService.getUserByUserName(registerRequest.getUserName()) != null){
            authResponse.setMessage("Username already exists.");
            return new ResponseEntity<>(authResponse, HttpStatus.BAD_REQUEST);
        }


        User user = registerRequest.convertToUser();
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        userService.saveUser(user);
        authResponse.setMessage("User successfully registered.");
        return new ResponseEntity<>(authResponse, HttpStatus.CREATED);
    }

}
