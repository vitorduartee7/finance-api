package com.vtduarte.financeapi.dto;

import lombok.Builder;

@Builder
public record TokenResponseDTO(String token, Long expires_in) {
}
