package com.cellphone.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity(name = "COMPANY")
@Getter
@Setter
public class Company extends BaseEntities {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "company_id")
    private Long companyId;
    private String name;
    private String description;
}
