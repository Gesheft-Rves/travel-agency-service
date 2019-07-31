package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour, Integer> {
}
