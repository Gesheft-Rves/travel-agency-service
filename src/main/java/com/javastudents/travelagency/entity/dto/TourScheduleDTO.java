package com.javastudents.travelagency.entity.dto;

import com.javastudents.travelagency.entity.Tour;
import com.javastudents.travelagency.entity.Transport;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TourScheduleDTO {
    private Integer id;
    private Tour tour;
    private String startingDateTime;
    private String endingDateTime;
    private Transport transport;
}
