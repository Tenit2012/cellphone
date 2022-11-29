package com.cellphone.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.*;

@ToString
@Entity(name = "CATEGORY")
@Getter
@Setter
public class Category extends BaseEntities {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long categoryId;
    private String name;
    private String description;
    private String image;

}
