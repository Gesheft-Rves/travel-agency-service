package com.javastudents.travelagency.entity.wrapper;

import com.javastudents.travelagency.entity.*;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@Builder @Getter @ToString
public class PurchaseWrapper implements Entity {
    private Integer purchaseId;
    private TourSchedule tourSchedule;
    private TravelAgent travelAgent;
    private Client client;
    private Transport transport;
    private TransportSeat transportSeat;
    private Timestamp operationDate;
}
