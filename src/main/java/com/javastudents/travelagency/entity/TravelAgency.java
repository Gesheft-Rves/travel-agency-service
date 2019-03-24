package com.javastudents.travelagency.entity;


import lombok.*;

@Builder
@ToString
@Getter @Setter
@EqualsAndHashCode
@AllArgsConstructor @NoArgsConstructor
public class TravelAgency implements Entity {
    private Integer id;
    private String abbreviatedName;
    private String address;
    private String phoneNumber;
    private String site;
    private String emailAddress;
}
