package com.javastudents.travelagency.entity;


import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Builder
@ToString
@Getter @Setter
@EqualsAndHashCode
public class TravelAgentLedger implements Entity {

    private Integer id;
    private Integer travelAgentId;
    private Timestamp operationDate;
    private Integer purchaseId;
    private BigDecimal amount;

}
