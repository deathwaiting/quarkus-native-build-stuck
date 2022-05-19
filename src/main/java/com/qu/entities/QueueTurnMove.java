package com.qu.entities;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;

import javax.persistence.*;

import java.util.Objects;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "queue_turn_insertion")
public class QueueTurnMove extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "insert_before_turn")
    public Long insertedBeforeTurnId;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "inserted_turn")
    public QueueTurn turn;

    @Column(name = "inserted_by")
    public String insertedBy;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueueTurnMove that = (QueueTurnMove) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
