package com.qu.entities;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "organization_admin_invitation")
public class AdminInvitation extends PanacheEntityBase {
    @Id
    private String id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @Column(name = "email")
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminInvitation that = (AdminInvitation) o;
        return Objects.equals(id, that.id) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    @Column(name = "roles")
    private String roles;

    @Column(name = "creation_time")
    private LocalDateTime creationTime;
}
