package com.vtduarte.financeapi.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record TransactionRequestDTO(@NotBlank String description,
                                    @NotNull @Positive BigDecimal amount,
                                    @PastOrPresent LocalDate date,
                                    @NotBlank @Size(max = 20) String type,
                                    @NotNull Long categoryId,
                                    @NotNull Long accountId) {
}
