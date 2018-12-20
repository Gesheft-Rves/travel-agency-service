package com.javastudents.travelagency.entity;

import lombok.*;


@Builder
@ToString
@Getter @Setter
@EqualsAndHashCode
public class AppPermission implements Entity {
    private Integer appPermissionId;
    private String name;
}
