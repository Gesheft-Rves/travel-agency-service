package com.javastudents.travelagency.entity;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class AppPermission   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer appPermissionId;

    @Column
    private String name;
}
