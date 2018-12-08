package com.javastudents.travelagency.entity;

import lombok.*;


@Builder
@ToString
@Getter @Setter
@EqualsAndHashCode
public class Customer implements Entity {

    private Integer id;
    private Integer departmentId;
    private String name;

}
