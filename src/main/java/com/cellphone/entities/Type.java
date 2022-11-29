package com.cellphone.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity(name = "TYPE")
@Getter
@Setter
public class Type extends BaseEntities {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "TYPE_ID")
    private Long typeId;
    private String name;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
}
