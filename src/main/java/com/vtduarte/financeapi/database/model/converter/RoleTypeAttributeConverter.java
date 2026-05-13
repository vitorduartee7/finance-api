package com.vtduarte.financeapi.database.model.converter;

import com.vtduarte.financeapi.database.model.enums.RoleType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RoleTypeAttributeConverter implements AttributeConverter<RoleType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(RoleType roleType){
        if (roleType == null) return null;
        return roleType.getValue();
    }

    @Override
    public RoleType convertToEntityAttribute(Integer integer){
        if (integer == null) return null;
        return RoleType.fromValue(integer);
    }
}
