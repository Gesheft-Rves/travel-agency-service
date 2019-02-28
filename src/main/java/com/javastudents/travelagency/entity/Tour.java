package com.javastudents.travelagency.entity;

import lombok.*;

import java.math.BigDecimal;

@Builder
@ToString
@Getter @Setter
@EqualsAndHashCode
@AllArgsConstructor @NoArgsConstructor
public class Tour implements Entity {
    private Integer tourId;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer tourCategoryId;

}
