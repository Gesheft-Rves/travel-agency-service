package com.javastudents.travelagency.entity.wrapper;

import com.javastudents.travelagency.entity.Entity;
import com.javastudents.travelagency.entity.TourCategory;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder @Getter
public class TourWrapper implements Entity {
    private Integer tourId;
    private String name;
    private String description;
    private BigDecimal price;
    private TourCategory tourCategory;
}
