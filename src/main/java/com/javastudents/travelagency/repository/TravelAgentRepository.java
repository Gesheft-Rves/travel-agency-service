package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.entity.TravelAgent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelAgentRepository extends JpaRepository<TravelAgent, Integer> {
}
