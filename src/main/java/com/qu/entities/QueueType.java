package com.qu.entities;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "queue_type")
public class QueueType extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "default_max_size")
    private Integer defaultMaxSize;

    @Column(name = "default_hold_enabled")
    private Boolean defaultHoldEnabled;

    @Column(name = "default_auto_accept_enabled")
    private Boolean defaultAutoAcceptEnabled;

    @Column(name = "organization_id")
    private Long organizationId;

    @OneToMany(mappedBy = "queueType", cascade = ALL)
    private Set<QueueEventHandler>  eventHandlers;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "default_enqueue_rate")
    private Float defaultEnqueueRate;

    @Column(name = "default_service_time")
    private Integer defaultServiceTimeMs;

    public QueueType(){
        eventHandlers = new HashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueueType queueType = (QueueType) o;
        return Objects.equals(id, queueType.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
