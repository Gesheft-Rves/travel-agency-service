package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
}
