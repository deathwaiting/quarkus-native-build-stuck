package com.qu.dto;


public class QueueRequestAnswerDto {
    public QueueRequestDto request;
    public QueueTurnDto turn;

    public QueueRequestAnswerDto(QueueRequestDto request, QueueTurnDto turn) {
        this.turn = turn;
        this.request = request;
    }
}
