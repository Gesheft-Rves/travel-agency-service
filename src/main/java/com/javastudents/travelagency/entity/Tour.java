package com.javastudents.travelagency.entity;

import lombok.*;

import java.math.BigDecimal;

@Builder
@ToString
@Getter @Setter
@EqualsAndHashCode
public class Tour implements Entity {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer tourCategoryId;
}
