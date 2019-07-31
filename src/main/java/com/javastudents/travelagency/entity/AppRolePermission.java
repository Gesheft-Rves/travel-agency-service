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

    @OneToOne
    @JoinColumn(name = "app_role_id")
    private AppRole appRole;

    @OneToOne
    @JoinColumn(name = "app_permission_id")
    private AppPermission appPermission;
}
