package com.qu.entities;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

import static com.qu.utils.Utils.nowAtUtc;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "queue_turn")
public class QueueTurn extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "queue_number")
    public String queueNumber;

    @Column(name = "enqueue_time", nullable = false)
    public LocalDateTime enqueueTime;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "request_id")
    public QueueRequest request;


    @OneToOne(fetch = LAZY, mappedBy = "turn")
    public QueueLeave leave;


    @OneToOne(fetch = LAZY, mappedBy = "turn")
    public QueueTurnMove turnMove;



    @OneToOne(fetch = LAZY, mappedBy = "turn")
    public QueueTurnPick pick;

    public QueueTurn() {
    }

    public QueueTurn(QueueRequest request, String queueNum){
        this.request = request;
        this.queueNumber = queueNum;
        this.enqueueTime = nowAtUtc();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueueTurn queueTurn = (QueueTurn) o;
        return Objects.equals(id, queueTurn.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
