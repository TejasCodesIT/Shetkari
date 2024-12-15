package com.farmer_project.farmer_project.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmer_project.farmer_project.Models.farmer;
import com.farmer_project.farmer_project.Repositories.farmer_repository;

@Service
public class farmer_Services {

    @Autowired
    private farmer_repository farmer_repository;

    
    public List<farmer> getallfarmerdata(){

        return farmer_repository.findAll();
    }

     // Add a new farmer
     public String addFarmer(farmer farmer) {
     farmer_repository.save(farmer);
     return "farmer data added";
    }

     // Find a farmer by ID
     public Optional<farmer> findFarmerById(Long id) {
        return farmer_repository.findById(id); // Return the result as Optional
    }

    public String deleteFarmerById(Long id) {
         farmer_repository.deleteById(id); 
         return "farmer data is deleted"; // Return the result as Optional
    }

     // Update a farmer by ID
     public String updateFarmer(Long id, farmer newFarmerData) {
        if (farmer_repository.existsById(id)) {
            newFarmerData.setId(id);  // Make sure the ID is set
            farmer_repository.save(newFarmerData); // Save the updated data
            return "Farmer updated successfully";
        } else {
            return "Farmer not found";
        }
    }
    
}
