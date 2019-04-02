package com.javastudents.travelagency.entity.dto;

import lombok.*;

import java.math.BigDecimal;

@Builder @ToString
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class TravelAgentDTO {
    private Integer id;
    private Integer travelAgencyId;
    private String name;
    private String surname;
    private String patronymic;
    private Boolean enabled;
    private String phoneNumber;
    private BigDecimal limitAmount;
}
