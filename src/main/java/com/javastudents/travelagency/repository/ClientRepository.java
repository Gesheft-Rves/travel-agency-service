package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
