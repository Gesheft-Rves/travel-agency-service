package com.javastudents.travelagency.entity;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private Integer tourScheduleId;

    @Column
    private Integer travelAgentId;

    @Column
    private Integer clientId;

    @Column
    private Integer transportId;

    @Column
    private Integer transportSeatId;

    @Column
    private Timestamp operationDate;
}
