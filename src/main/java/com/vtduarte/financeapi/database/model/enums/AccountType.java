package com.vtduarte.financeapi.database.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum AccountType {

    CHECKING(1, "conta corrente"),
    SAVINGS(2, "poupança"),
    CASH(3, "dinheiro físico"),
    CREDIT(4, "cartão de crédito");

    private final Integer value;
    private final String description;

    public static AccountType fromValue(Integer value) {
        return Stream.of(AccountType.values())
                .filter(item -> item.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("AccountType not found for value: " + value));
    }
}
