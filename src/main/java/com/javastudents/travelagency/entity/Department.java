package com.javastudents.travelagency.entity;

import lombok.*;

@Builder
@ToString
@Getter @Setter
@EqualsAndHashCode
public class Department implements Entity {

    Integer id;
    String name;
}
