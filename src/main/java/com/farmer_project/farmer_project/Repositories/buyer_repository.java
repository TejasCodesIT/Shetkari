package com.farmer_project.farmer_project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmer_project.farmer_project.Models.buyer;

@Repository
public interface buyer_repository extends JpaRepository<buyer, Long>{
    
}
