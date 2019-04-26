package com.javastudents.travelagency.entity;


import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class TransportSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transport_seat_id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "transport_id")
    private Transport transport;

    @Column(name = "seat_no")
    private Integer seatNo;

    @Column
    private String comment;

    public TransportSeat(Transport transport, Integer seatNo, String comment) {
        this.transport = transport;
        this.seatNo = seatNo;
        this.comment = comment;
    }
}
