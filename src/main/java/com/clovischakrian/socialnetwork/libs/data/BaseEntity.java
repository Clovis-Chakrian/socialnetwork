package com.clovischakrian.socialnetwork.libs.data;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
    private Date createdAt;
    private Date updatedAt;

    @PrePersist
    public void onPrePersist() {
        Date now = new Date();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    public void onPreUpdate() {
        this.updatedAt = new Date();
    }
}
