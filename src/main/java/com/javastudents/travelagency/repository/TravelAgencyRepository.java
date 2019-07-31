package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.entity.TravelAgency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelAgencyRepository extends JpaRepository<TravelAgency, Integer> {
}
