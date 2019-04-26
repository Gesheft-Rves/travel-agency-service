package com.javastudents.travelagency.entity;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class TourSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tour_schedule_id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @Column
    private Timestamp startingDateTime;

    @Column
    private Timestamp endingDateTime;

    @OneToOne
    @JoinColumn(name = "transport_id")
    private Transport transport;

    public TourSchedule(Tour tour, Timestamp startingDateTime, Timestamp endingDateTime, Transport transport) {
        this.tour = tour;
        this.startingDateTime = startingDateTime;
        this.endingDateTime = endingDateTime;
        this.transport = transport;
    }
}
