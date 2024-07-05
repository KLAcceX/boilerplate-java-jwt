package com.kl.jwt.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterRequestDTO {
    private String fullName;
    private String email;
    private String password;
}
