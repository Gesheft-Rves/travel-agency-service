package com.javastudents.travelagency.entity;

import lombok.*;


@Builder
@ToString
@Getter @Setter
@EqualsAndHashCode
public class AppUser implements Entity {
    private Integer appUserId;
    private String name;
    private String surname;
    private String email;
    private String login;
    private String password;
    private Integer travelAgentId;
}
