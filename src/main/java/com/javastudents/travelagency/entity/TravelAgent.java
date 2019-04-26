package com.javastudents.travelagency.entity;


import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class TravelAgent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "travel_agent_id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "travel_agency_id")
    private TravelAgency travelAgency;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String patronymic;

    @Column
    private Boolean enabled;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "limit_amount")
    private BigDecimal limitAmount;

    public TravelAgent(TravelAgency travelAgency, String name, String surname, String patronymic, Boolean enabled, String phoneNumber, BigDecimal limitAmount) {
        this.travelAgency = travelAgency;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.enabled = enabled;
        this.phoneNumber = phoneNumber;
        this.limitAmount = limitAmount;
    }
}
