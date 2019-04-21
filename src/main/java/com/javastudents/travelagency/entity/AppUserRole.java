package com.javastudents.travelagency.entity;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class AppUserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer appUserRoleId;

    @OneToOne
    @JoinColumn
    private AppUser appUser;

    @OneToOne
    @JoinColumn
    private AppRole appRole;
}
