package com.farmer_project.farmer_project.Controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import com.farmer_project.farmer_project.Models.farmer;
import com.farmer_project.farmer_project.Services.farmer_Services;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;





@RestController
public class farmer_Controller {

    @Autowired
    private farmer_Services farmer_Services;

    @GetMapping("getfarmer")
    public List<farmer> getallfarmerdata() {
        return farmer_Services.getallfarmerdata();
    
    }
     // Add a new farmer
    @PostMapping("addfarmer")
    public String addFarmer(@RequestBody farmer farmer) {
         farmer_Services.addFarmer(farmer);
         return "farmer data added sucessfully";
    }
    
    @DeleteMapping("deletefarmer/{id}")
    public String deletefarmerById(@PathVariable Long id) {
     farmer_Services.deleteFarmerById(id);
     return "farmer data is deleted";
    }

     @PutMapping("updatefarmer/{id}")
    public String updateFarmer(@PathVariable Long id, @RequestBody farmer updatedFarmer) {
     farmer_Services.updateFarmer(id, updatedFarmer);

     return "Farmer with ID " + id + " has been deleted.";
    }
    
}
