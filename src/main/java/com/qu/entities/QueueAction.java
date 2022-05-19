package com.qu.entities;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "queue_actions")
public class QueueAction extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "queue_id")
    public Queue queue;

    @Column(name = "action_time")
    public LocalDateTime actionTime;

    @Column(name = "action_type")
    public String actionType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueueAction that = (QueueAction) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
