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
@Entity(name = "AREA")
@Getter
@Setter
public class Area extends BaseEntities {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long areaId;

    private String name;

    private String description;

}
