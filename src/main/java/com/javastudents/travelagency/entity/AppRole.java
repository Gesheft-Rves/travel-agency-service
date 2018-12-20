package com.javastudents.travelagency.entity;

import lombok.*;


@Builder
@ToString
@Getter @Setter
@EqualsAndHashCode
public class AppRole implements Entity {
    private Integer appRoleId;
    private String name;
}
