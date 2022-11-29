package com.cellphone.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntities implements Serializable {

    private static final long serialVersionUID = 1L;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    private boolean disable;

    @PrePersist
    protected void onCreate() {
        Date date = new Date();
        this.setCreatedAt(date);
        this.setUpdatedAt(date);
    }

    @PreUpdate
    protected void onUpdate() {
        Date date = new Date();
        this.setUpdatedAt(date);
    }

}
