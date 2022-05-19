package com.qu.entities;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;

import javax.persistence.*;

import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "queue_event_handler")
public class QueueEventHandler extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "event_type")
    public String eventType;

    @Column(name = "common_data")
    public String commonData;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "queue_type_id")
    public QueueType queueType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueueEventHandler that = (QueueEventHandler) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
