package com.javastudents.travelagency.entity;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "tour_schedule_id")
    private TourSchedule tourSchedule;

    @OneToOne
    @JoinColumn(name = "travel_agent_id")
    private TravelAgent travelAgent;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne
    @JoinColumn(name = "transport_id")
    private Transport transport;

    @OneToOne
    @JoinColumn(name = "transport_seat_id")
    private TransportSeat transportSeat;

    @Column
    private Timestamp operationDate;

    public Purchase(TourSchedule tourSchedule, TravelAgent travelAgent, Client client, Transport transport, TransportSeat transportSeat, Timestamp operationDate) {
        this.tourSchedule = tourSchedule;
        this.travelAgent = travelAgent;
        this.client = client;
        this.transport = transport;
        this.transportSeat = transportSeat;
        this.operationDate = operationDate;
    }
}
