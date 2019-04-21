package com.javastudents.travelagency.entity.dto;

import com.javastudents.travelagency.entity.Entity;
import com.javastudents.travelagency.entity.TravelAgent;
import lombok.*;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppUserDTO implements Entity {
    private Integer appUserId;
    private String name;
    private String surname;
    private String email;
    private String login;
    private String password;
    private TravelAgent travelAgent;
}
