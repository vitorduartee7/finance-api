package com.vtduarte.financeapi.database.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum CategoryType {

    INCOME(1, "receita"),
    EXPENSE(2, "despesa");

    private final Integer value;
    private final String description;

    public static CategoryType fromValue(Integer value) {
        return Stream.of(CategoryType.values())
                .filter(item -> item.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("CategoryType not found for value: " + value));
    }
}
