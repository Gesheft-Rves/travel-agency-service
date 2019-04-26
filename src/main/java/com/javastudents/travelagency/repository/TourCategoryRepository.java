package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.entity.TourCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourCategoryRepository extends JpaRepository<TourCategory, Integer> {
}
