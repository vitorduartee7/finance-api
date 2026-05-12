package com.vtduarte.financeapi.database.repository;

import com.vtduarte.financeapi.database.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Long> {
}
