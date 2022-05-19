package com.qu.dto;

import java.util.ArrayList;
import java.util.List;

public class QueueTypeDto {
    public Long id;
    public Boolean defaultAutoAcceptEnabled;
    public Integer defaultMaxSize;
    public Boolean defaultHoldEnabled;
    public String name;
    public List<QueueEventDto> eventHandlers;
    public Float defaultEnqueueRate;
    public Integer defaultServiceTime;

    public QueueTypeDto(){
        eventHandlers = new ArrayList<>();
    }
}
