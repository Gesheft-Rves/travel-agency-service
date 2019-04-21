package com.javastudents.travelagency.entity;


import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Builder
@ToString
@Getter @Setter
@EqualsAndHashCode
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TravelAgent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "travel_agent_id")
    private Integer id;

    @Column
    private Integer travelAgencyId;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String patronymic;

    @Column
    private Boolean enabled;

    @Column
    private String phoneNumber;

    @Column
    private BigDecimal limitAmount;

}
