package com.javastudents.travelagency.repository;

import com.javastudents.travelagency.entity.AppPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppPermissionRepository extends JpaRepository<AppPermission, Integer> {
}
