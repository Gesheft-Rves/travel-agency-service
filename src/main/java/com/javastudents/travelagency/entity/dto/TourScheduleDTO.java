package com.javastudents.travelagency.entity.dto;

import com.javastudents.travelagency.entity.Tour;
import com.javastudents.travelagency.entity.Transport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class TourScheduleDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tour_schedule_id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @Column
    private String startingDateTime;

    @Column
    private String endingDateTime;

    @OneToOne
    @JoinColumn(name = "transport_id")
    private Transport transport;

    public TourScheduleDTO(Tour tour, String startingDateTime, String endingDateTime, Transport transport) {
        this.tour = tour;
        this.startingDateTime = startingDateTime;
        this.endingDateTime = endingDateTime;
        this.transport = transport;
    }
}
