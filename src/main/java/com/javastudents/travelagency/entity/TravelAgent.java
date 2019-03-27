package com.javastudents.travelagency.entity;


import lombok.*;

import java.math.BigDecimal;

@Builder
@ToString
@Getter @Setter
@EqualsAndHashCode
@AllArgsConstructor @NoArgsConstructor
public class TravelAgent implements Entity {
    private Integer id;
    private TravelAgency travelAgency;
    private String name;
    private String surname;
    private String patronymic;
    private Boolean enabled;
    private String phoneNumber;
    private BigDecimal limitAmount;
}
