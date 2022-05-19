package com.qu.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Map;

public class QueueEventDto {
    public String eventHandlerName;
    public Map<String, ?> commonParams;
}
