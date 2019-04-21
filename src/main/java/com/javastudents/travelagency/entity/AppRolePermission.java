package com.javastudents.travelagency.entity;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class AppRolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer appRolePermissionId;

    @Column
    private Integer appRoleId;

    @Column
    private Integer appPermissionId;
}
