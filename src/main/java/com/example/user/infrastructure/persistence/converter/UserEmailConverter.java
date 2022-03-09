package com.example.user.infrastructure.persistence.converter;

import com.example.user.domain.model.UserEmail;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class UserEmailConverter implements AttributeConverter<UserEmail, String> {
    @Override
    public String convertToDatabaseColumn(UserEmail attribute) {
        return attribute.value();
    }

    @Override
    public UserEmail convertToEntityAttribute(String dbData) {
        return new UserEmail(dbData);
    }
}
