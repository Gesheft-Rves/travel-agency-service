package com.javastudents.travelagency.entity.dto;

import com.javastudents.travelagency.entity.Entity;
import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class TourDTO implements Entity {
    private Integer tourId;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer tourCategoryId;
}
