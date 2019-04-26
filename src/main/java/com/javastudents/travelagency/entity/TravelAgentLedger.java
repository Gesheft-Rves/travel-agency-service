package com.javastudents.travelagency.entity;


import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class TravelAgentLedger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "travel_agent_ledger_id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "travel_agent_id")
    private TravelAgent travelAgent;

    @Column(name = "operation_date")
    private Timestamp operationDate;

    @OneToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @Column(name = "amount")
    private BigDecimal amount;

    public TravelAgentLedger(TravelAgent travelAgent, Timestamp operationDate, Purchase purchase, BigDecimal amount) {
        this.travelAgent = travelAgent;
        this.operationDate = operationDate;
        this.purchase = purchase;
        this.amount = amount;
    }
}
