package com.javastudents.travelagency.entity.dto;

import com.javastudents.travelagency.entity.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class PurchaseDTO {
    private Integer id;
    private TourSchedule tourSchedule;
    private TravelAgent travelAgent;
    private Client client;
    private Transport transport;
    private TransportSeat transportSeat;
    private String operationDate;
}
