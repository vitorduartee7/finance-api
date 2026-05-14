package com.vtduarte.financeapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record LoginRequestDTO(@NotBlank @Email String email,
                              @NotBlank @Size(min = 8, max = 40) String password) {
}
