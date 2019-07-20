package com.javastudents.travelagency.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity @Builder
public class TourSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tour_schedule_id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime startingDateTime;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime endingDateTime;

    @OneToOne
    @JoinColumn(name = "transport_id")
    private Transport transport;

    public TourSchedule(Tour tour, LocalDateTime startingDateTime, LocalDateTime endingDateTime, Transport transport) {
        this.tour = tour;
        this.startingDateTime = startingDateTime;
        this.endingDateTime = endingDateTime;
        this.transport = transport;
    }
}
