package com.vtduarte.financeapi.database.model.converter;

import com.vtduarte.financeapi.database.model.enums.CategoryType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CategoryTypeAttributeConverter implements AttributeConverter<CategoryType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(CategoryType categoryType){
        if (categoryType == null) return null;
        return categoryType.getValue();
    }

    @Override
    public CategoryType convertToEntityAttribute(Integer integer){
        if (integer == null) return null;
        return CategoryType.fromValue(integer);
    }
}
