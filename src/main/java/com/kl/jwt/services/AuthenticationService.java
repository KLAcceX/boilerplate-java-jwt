package com.kl.jwt.services;

import java.util.HashSet;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kl.jwt.dtos.requests.LoginRequestDTO;
import com.kl.jwt.dtos.requests.RegisterRequestDTO;
import com.kl.jwt.dtos.responses.LoginResponseDTO;
import com.kl.jwt.dtos.responses.RegisterResponseDTO;
import com.kl.jwt.entities.User;
import com.kl.jwt.entities.UserRole;
import com.kl.jwt.repositories.UserRepository;
import com.kl.jwt.repositories.UserRoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final JwtService jwtService;

    public RegisterResponseDTO register(RegisterRequestDTO request) {
        var roles = userRoleRepository.findByName("USER");
        var user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(new HashSet<UserRole>(roles))
                .build();
        userRepository.save(user);
        return RegisterResponseDTO.builder().message("Created user with basic permissions").build();
    }

    public LoginResponseDTO login(LoginRequestDTO request) {
        var authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        if (authentication.isAuthenticated())
            return LoginResponseDTO.builder().accessToken(jwtService.generateToken(request.getEmail())).build();
        throw new UsernameNotFoundException("Invalid request");
    }

}
