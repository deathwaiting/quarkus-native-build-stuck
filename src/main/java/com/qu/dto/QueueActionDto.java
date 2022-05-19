package com.qu.dto;

import com.qu.commons.enums.QueueActionType;

import java.time.ZonedDateTime;

public class QueueActionDto {
    public QueueActionType action;
    public ZonedDateTime actionTime;
}
