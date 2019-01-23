package com.javastudents.travelagency.entity;

import lombok.*;


@Builder
@ToString
@Getter @Setter
@EqualsAndHashCode
public class AppUserRole implements Entity {
    private Integer appUserRoleId;
    private Integer appUserId;
    private Integer roleId;
}
