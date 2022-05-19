package com.qu.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Map;

public class QueueTurnCreateDto extends QueueRequestCreateDto{
    public Long turnAfter;
}
