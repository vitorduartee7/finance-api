package com.vtduarte.financeapi.database.model.converter;

import com.vtduarte.financeapi.database.model.enums.TransactionType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TransactionTypeAttributeConverter implements AttributeConverter<TransactionType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TransactionType transactionType) {
        if (transactionType == null) return null;
        return transactionType.getValue();
    }

    @Override
    public TransactionType convertToEntityAttribute(Integer integer) {
        if (integer == null) return null;
        return TransactionType.fromValue(integer);
    }
}
