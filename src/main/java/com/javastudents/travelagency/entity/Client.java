package com.javastudents.travelagency.entity;

import lombok.*;


@Builder
@ToString
@Getter @Setter
@EqualsAndHashCode
public class Client implements Entity {
    private Integer clientId;
    private Integer documentTypeId;
    private String documentSeriesNumber;
    private String name;
    private String surname;
    private String patronymic;
    private String address;
    private String phoneNumber;
}
