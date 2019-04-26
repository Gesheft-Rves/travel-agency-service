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
    @JoinColumn(name = "document_type_id")
    private DocumentType documentTypeId;

    @Column(name = "document_series_number")
    private String documentSeriesNumber;

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

    public Client(DocumentType documentTypeId, String documentSeriesNumber, String name, String surname, String patronymic, String address, String phoneNumber) {
        this.documentTypeId = documentTypeId;
        this.documentSeriesNumber = documentSeriesNumber;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
