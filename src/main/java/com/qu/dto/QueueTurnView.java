package com.qu.dto;

import java.time.ZonedDateTime;

public class QueueTurnView extends QueueTurnDto{
    public Integer order;
    public boolean nextTurn;
    public ZonedDateTime expectedPickTime;
}
