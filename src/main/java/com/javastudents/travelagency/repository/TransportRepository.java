package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.entity.Transport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportRepository extends JpaRepository<Transport, Integer> {
}
