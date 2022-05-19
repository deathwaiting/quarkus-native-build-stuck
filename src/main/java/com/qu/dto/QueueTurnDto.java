package com.qu.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qu.commons.enums.TurnStatus;

import java.time.ZonedDateTime;
import java.util.Map;

public class QueueTurnDto {
    public Long id;
    public String clientId;
    public Map<String,?> clientDetails;
    public ZonedDateTime enqueueTime;
    public String acceptorId;
    public String number;
    public ZonedDateTime leaveTime;
    public ZonedDateTime pickTime;
    public ZonedDateTime skipTime;
    public ZonedDateTime endTime;
    public String skipReason;
    public String picker;
    public Map<String,?> pickerDetails;
    public TurnStatus status;
    public String uuid;
    public Long quId;
    @JsonIgnore
    public Long turnAfter;
    @JsonIgnore
    public Long requestId;
}
