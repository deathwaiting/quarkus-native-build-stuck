package com.qu.entities;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "queue")
public class Queue extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "start_time")
    public LocalDateTime startTime;

    @Column(name = "end_time")
    public LocalDateTime endTime;

    @Column(name = "max_size")
    public Integer maxSize;

    @Column(name = "hold_enabled")
    public Boolean holdEnabled;

    @Column(name = "auto_accept_enabled")
    public Boolean autoAcceptEnabled;


    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "queue_type_id")
    public QueueType type;



    @OneToMany(mappedBy = "queue", fetch = LAZY, cascade = ALL)
    public Set<QueueRequest> requests;



    @OneToMany(mappedBy = "queue", fetch = LAZY)
    public Set<QueueAction> actions;

    @Column(name = "number_generator")
    public String numberGenerator;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Queue queue = (Queue) o;
        return Objects.equals(id, queue.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static class QueueListPage{
        public Integer totalPagesCount;
        public List<Queue> page;

        public QueueListPage(Integer pgCount, List<Queue> page){
            this.totalPagesCount = pgCount;
            this.page = page;
        }
    }
}
