package com.vtduarte.financeapi.database.repository;

import com.vtduarte.financeapi.database.model.Category;
import com.vtduarte.financeapi.database.model.enums.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByUserId(Long userId);

    Optional<Category> findByIdAndUserId(Long id, Long userId);

    List<Category> findByTypeAndUserId(CategoryType categoryType, Long userId);
}
