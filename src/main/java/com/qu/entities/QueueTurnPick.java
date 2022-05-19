package com.qu.entities;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "queue_turn_pick")
public class QueueTurnPick extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "pick_time")
    public LocalDateTime pickTime;

    @Column(name = "skip_time")
    public LocalDateTime skipTime;

    @Column(name = "skip_reason")
    public String skipReason;

    @Column(name = "server_id")
    public String serverId;

    @Column(name = "server_details")
    public String serverDetails;

    @Column(name = "end_time")
    public LocalDateTime endTime;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "queue_turn_id")
    public QueueTurn turn;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueueTurnPick that = (QueueTurnPick) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
