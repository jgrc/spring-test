package com.example.user.infrastructure.io.serializer;

import com.example.user.domain.model.User;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;
import java.io.IOException;

@JsonComponent
public class UserJsonSerializer extends JsonSerializer<User> {
    @Override
    public void serialize(
        User user,
        JsonGenerator gen,
        SerializerProvider serializers
    ) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("id", user.id().value().toString());
        gen.writeStringField("email", user.email().value());
        gen.writeEndObject();
    }
}
