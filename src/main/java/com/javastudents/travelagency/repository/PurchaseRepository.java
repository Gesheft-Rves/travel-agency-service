package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
}
