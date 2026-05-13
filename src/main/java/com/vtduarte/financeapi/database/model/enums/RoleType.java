package com.vtduarte.financeapi.database.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum RoleType {

    ADMIN(1, "Admin"),
    USER(2, "User"),;

    private final Integer value;
    private final String description;

    public static RoleType fromValue(Integer value) {
        return Stream.of(RoleType.values())
                .filter(item -> item.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("RoleType not found for value: " + value));
    }
}
