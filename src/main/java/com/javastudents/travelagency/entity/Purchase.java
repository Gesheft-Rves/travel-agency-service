package com.javastudents.travelagency.entity;

import lombok.*;

import java.sql.Timestamp;

@Builder
@ToString
@Getter @Setter
@EqualsAndHashCode
@AllArgsConstructor @NoArgsConstructor
public class Purchase implements Entity {
    private Integer purchaseId;
    private TourSchedule tourSchedule;
    private TravelAgent travelAgent;
    private Client client;
    private Transport transport;
    private TransportSeat transportSeat;
    private Timestamp operationDate;
}
