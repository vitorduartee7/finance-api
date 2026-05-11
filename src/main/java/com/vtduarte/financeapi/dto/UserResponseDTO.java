package com.vtduarte.financeapi.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UserResponseDTO(Long id,
                              String name,
                              String email,
                              LocalDateTime createdAt) {
}
