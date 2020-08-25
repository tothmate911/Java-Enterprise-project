package com.codecool.librarymanagement.controller;

import com.codecool.librarymanagement.entity.Book;
import com.codecool.librarymanagement.entity.BookUser;
import com.codecool.librarymanagement.model.generated.UserCredentials;
import com.codecool.librarymanagement.repository.UserRepository;
import com.codecool.librarymanagement.security.JwtTokenService;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtTokenService jwtTokenService;
    private PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenService jwtTokenService, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
        this.userRepository = userRepository;
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @PostMapping("/signin")
    public ResponseEntity signIn(@RequestBody UserCredentials data) {
        System.out.println(data);
        try {
            String username = data.getUsername();
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, data.getPassword()));
            List<String> roles = authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            String token = jwtTokenService.createToken(username, roles);
            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("roles", roles);
            model.put("token", token);
            return ResponseEntity.ok(model);
        } catch (AuthenticationException exception) {
            throw new BadCredentialsException("Invalid username or password!");
        }
    }

    @PostMapping("/register")
    public boolean registerNewUser(@RequestBody UserCredentials data) {
        if (userRepository.findByUsername(data.getUsername()).isEmpty()) {
            userRepository.save(BookUser.builder()
                    .username(data.getUsername())
                    .password(passwordEncoder.encode(data.getPassword()))
                    .email(data.getEmail())
                    .roles(Arrays.asList("ROLE_USER"))
                    .build()
            );
            return true;
        } else {
            System.out.println("USERNAME IS ALREADY TAKEN!!!!!4444");
            return false;
        }
    }
}
