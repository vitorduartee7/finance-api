package com.vtduarte.financeapi.database.model.converter;

import com.vtduarte.financeapi.database.model.enums.AccountType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AccountTypeAttributeConverter implements AttributeConverter<AccountType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(AccountType accountType) {
        if (accountType == null) return null;
        return accountType.getValue();
    }

    @Override
    public AccountType convertToEntityAttribute(Integer integer) {
        if (integer == null) return null;
        return AccountType.fromValue(integer);
    }
}
