package com.farmer_project.farmer_project.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmer_project.farmer_project.Models.buyer;
import com.farmer_project.farmer_project.Repositories.buyer_repository;



@Service
public class buyer_services {

     @Autowired
    private buyer_repository buyer_repository;

    
    public List<buyer> getallbuyerdata(){

        return buyer_repository.findAll();
    }

     // Add a new buyer
     public String addbuyer(buyer buyer) {
        buyer_repository.save(buyer);
     return "buyer data added";
    }

     // Find a buyer by ID
     public Optional<buyer> findbuyerById(Long id) {
        return buyer_repository.findById(id); 
    }

    public String deletebuyerById(Long id) {
        buyer_repository.deleteById(id); 
         return "buyer data is deleted"; 
    }

     // Update a buyer by ID
     public String updatebuyer(Long id, buyer newbuyerData) {
        if (buyer_repository.existsById(id)) {
            newbuyerData.setId(id);  
            buyer_repository.save(newbuyerData); 
            return "Farmer updated successfully";
        } else {
            return "Farmer not found";
        }
    }
    
    
}
