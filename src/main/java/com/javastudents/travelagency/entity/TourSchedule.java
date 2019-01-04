package com.javastudents.travelagency.entity;

import lombok.*;

import java.sql.Timestamp;

@Builder
@ToString
@Getter @Setter
@EqualsAndHashCode
public class TourSchedule implements Entity {
    private Integer id;
    private Integer tourId;
    private Timestamp startingDateTime;
    private Timestamp endingDateTime;
    private Integer transportId;
}
