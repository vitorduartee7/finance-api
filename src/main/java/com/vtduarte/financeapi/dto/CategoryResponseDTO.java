package com.vtduarte.financeapi.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record CategoryResponseDTO(Long id,
                                  String name,
                                  String type,
                                  LocalDateTime createdAt) {
}
