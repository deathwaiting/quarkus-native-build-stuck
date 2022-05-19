package com.qu.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.smallrye.mutiny.Multi;

import java.util.List;

public class QueueListResponse {
    public List<QueueDto> queues;
    public Integer pagesCount;

    public QueueListResponse(Integer pagesCount, List<QueueDto> queues){
        this.queues = queues;
        this.pagesCount = pagesCount;
    }
}
