package com.javastudents.travelagency.entity;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private BigDecimal price;

    @Column
    private Integer tourCategoryId;
}
