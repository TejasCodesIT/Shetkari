package com.farmer_project.farmer_project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmer_project.farmer_project.Models.product;

@Repository
public interface product_repository extends JpaRepository<product, Long> {
    
}
