package com.qu.dto;

import java.util.List;

public class QueueDetailsDto extends QueueDto{
    public List<QueueActionDto> actions;
    public List<QueueRequestDto> requests;
    public List<QueueTurnView> turns;
    public Long nextTurn;
    public String turnRequestFormUrl;
}
