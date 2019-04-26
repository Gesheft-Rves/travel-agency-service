package com.javastudents.travelagency.entity;


import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class TravelAgency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "travel_agency_id")
    private Integer id;

    @Column(name = "abbreviated_name")
    private String abbreviatedName;

    @Column
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column
    private String site;

    @Column(name = "email_address")
    private String emailAddress;
}
