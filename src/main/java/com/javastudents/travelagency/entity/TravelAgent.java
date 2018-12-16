package com.javastudents.travelagency.entity;


import lombok.*;

import java.math.BigDecimal;

@Builder
@ToString
@Getter @Setter
@EqualsAndHashCode
public class TravelAgent implements Entity {

    private Integer id;
    private Integer travelAgencyId;
    private String name;
    private String surname;
    private String patronymic;
    private boolean enabled;
    private Integer phone_number;
    private BigDecimal limit_amount;

}
