package fr.springBoot.jpalibrary.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class CategoryTypeConverter implements AttributeConverter<CategoryType, String> {
    @Override
    public String convertToDatabaseColumn(CategoryType categoryType) {
        if (categoryType == null) {
            return null;
        }
        return categoryType.getType();
    }

    @Override
    public CategoryType convertToEntityAttribute(String categoryType) {
        if (categoryType == null) {
            return null;
        }

        return Stream.of(CategoryType.values())
                .filter(c -> c.getType().equals(categoryType))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
