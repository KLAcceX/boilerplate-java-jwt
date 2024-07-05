package com.kl.jwt.dtos.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterResponseDTO {
    private String message;
}
