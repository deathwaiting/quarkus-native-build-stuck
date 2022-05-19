package com.qu.dto;

import com.qu.commons.enums.RequestStatus;

import java.time.ZonedDateTime;
import java.util.Map;

public class QueueRequestDto {
    public ZonedDateTime requestTime;
    public String clientId;
    public Map<String,?> clientDetails;
    public Boolean refused;
    public Boolean cancelled;
    public Boolean accepted;
    public String refuser;
    public ZonedDateTime responseTime;
    public Long id;
    public Long queueId;
    public boolean autoAccept;
    public String uuid;
    public RequestStatus status;
}
