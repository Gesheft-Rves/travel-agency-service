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
    @Column(name = "tour_id")
    private Integer id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private BigDecimal price;

    @OneToOne
    @JoinColumn(name = "tour_category_id")
    private TourCategory tourCategory;

    public Tour(String name, String description, BigDecimal price, TourCategory tourCategory) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.tourCategory = tourCategory;
    }
}
