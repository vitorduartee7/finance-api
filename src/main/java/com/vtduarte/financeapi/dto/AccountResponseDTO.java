package com.vtduarte.financeapi.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record AccountResponseDTO(Long id,
                                 String name,
                                 BigDecimal balance,
                                 String type,
                                 LocalDateTime createdAt) {
}
