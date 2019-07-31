package com.javastudents.travelagency.entity;

import javax.persistence.*;
import javax.persistence.Entity;

import lombok.*;

@Entity
@ToString
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppUser{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer appUserId;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String email;

    @Column
    private String login;

    @Column
    private String password;

    @OneToOne
    @JoinColumn(name = "travel_agent_id")
    private TravelAgent travelAgent;
}
