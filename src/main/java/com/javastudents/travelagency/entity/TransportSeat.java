package com.javastudents.travelagency.entity;


import lombok.*;

@Builder
@ToString
@Getter @Setter
@EqualsAndHashCode
public class TransportSeat implements Entity {
    private Integer id;
    private Integer transportId;
    private Integer seatNo;
    private String comment;
}
