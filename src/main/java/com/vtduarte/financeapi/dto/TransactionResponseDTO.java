package com.vtduarte.financeapi.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record TransactionResponseDTO(Long id,
                                     String description,
                                     BigDecimal amount,
                                     LocalDate date,
                                     String type,
                                     String categoryName,
                                     String accountName,
                                     LocalDateTime createdAt) {
}
