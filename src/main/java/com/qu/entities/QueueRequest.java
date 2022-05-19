package com.qu.entities;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name= "queue_request")
public class QueueRequest extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "acceptor_id")
    public String acceptorId;

    @Column(name = "client_id")
    public String clientId;

    @Column(name = "request_time")
    public LocalDateTime requestTime;

    @Column(name = "response_time")
    public LocalDateTime responseTime;

    @Column(name = "client_details")
    public String clientDetails;

    @Column(name = "refused")
    private Boolean refused;

    @Column(name = "cancelled")
    private Boolean cancelled;

    @Column(name = "uuid")
    public String uuid;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "queue_id")
    public Queue queue;


    @OneToOne(fetch = LAZY, mappedBy = "request")
    public QueueTurn turn;


    public Boolean getCancelled() {
        return ofNullable(cancelled).orElse(false);
    }

    public Boolean getRefused() {
        return ofNullable(refused).orElse(false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueueRequest that = (QueueRequest) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
