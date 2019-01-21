package com.javastudents.travelagency.entity;

import lombok.*;

import java.sql.Timestamp;

@Builder
@ToString
@Getter @Setter
@EqualsAndHashCode
public class Purchase implements Entity {
    private Integer id;
    private Integer tourScheduleId;
    private Integer travelAgentId;
    private Integer clientId;
    private Integer transportId;
    private Integer transportSeatId;
    private Timestamp operationDate;
}
