package com.javastudents.travelagency.entity;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer clientId;

    @OneToOne
    @JoinColumn
    private DocumentType documentTypeId;

    @OneToOne
    @JoinColumn
    private DocumentType documentSeriesNumber;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String patronymic;

    @Column
    private String address;

    @Column
    private String phoneNumber;
}
