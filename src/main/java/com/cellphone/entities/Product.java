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
@Entity(name = "PRODUCT")
@Getter
@Setter
public class Product extends BaseEntities {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Long productId;
    private String name;
    private Long price;
    private Long salePrice;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private Type type;
    private String description;
}
