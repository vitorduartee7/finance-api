package com.vtduarte.financeapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record AccountRequestDTO(@NotBlank @Size(max = 40) String name,
                                @NotNull @Positive BigDecimal balance,
                                @NotBlank @Size(max = 20) String type) {
}
