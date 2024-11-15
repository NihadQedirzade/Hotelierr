package com.example.hoteliermvc.repositories;

import com.example.hoteliermvc.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
