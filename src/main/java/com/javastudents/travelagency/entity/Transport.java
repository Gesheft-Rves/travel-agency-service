package com.javastudents.travelagency.entity;

import lombok.*;

@Builder
@ToString
@Getter @Setter
@EqualsAndHashCode
public class Transport implements Entity {
    private Integer id;
    private String name;
    private String description;
    private Integer passengerSeatQty;
}
