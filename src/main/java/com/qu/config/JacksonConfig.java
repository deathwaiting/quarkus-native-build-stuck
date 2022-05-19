package com.qu.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.jackson.ObjectMapperCustomizer;

import javax.inject.Singleton;

import static com.fasterxml.jackson.databind.DeserializationFeature.*;

@Singleton
public class JacksonConfig implements ObjectMapperCustomizer {
    @Override
    public void customize(ObjectMapper objectMapper) {
        objectMapper.enable(ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        objectMapper.disable(FAIL_ON_UNKNOWN_PROPERTIES, FAIL_ON_IGNORED_PROPERTIES);
    }
}
