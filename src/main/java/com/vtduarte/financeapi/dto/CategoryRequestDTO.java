package com.vtduarte.financeapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record CategoryRequestDTO(@NotBlank @Size(max = 40) String name,
                                 @NotBlank @Size(max = 20) String type) {
}
