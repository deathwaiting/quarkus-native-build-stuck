package com.qu.dto;

import com.qu.commons.enums.QueueActionType;

import java.time.ZonedDateTime;

public class QueueDto {
    public Long id;
    public Boolean autoAcceptEnabled;
    public Integer maxSize;
    public Boolean holdEnabled;
    public ZonedDateTime startTime;
    public ZonedDateTime endTime;
    public Long queueTypeId;
    public String typeName;
    public String name;
    public QueueActionType status;
}
