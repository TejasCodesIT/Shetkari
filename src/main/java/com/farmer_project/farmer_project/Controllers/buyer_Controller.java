package com.farmer_project.farmer_project.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*; // Import RestController annotations

import com.farmer_project.farmer_project.Models.buyer;
import com.farmer_project.farmer_project.Services.buyer_services;

@RestController // Changed from @Controller to @RestController
public class buyer_Controller {

    @Autowired
    private buyer_services buyer_Services;

    @GetMapping("/getbuyer") // Add a forward slash for consistency
    public List<buyer> getallbuyerdata() {
        return buyer_Services.getallbuyerdata();
    }

    // Add a new buyer
    @PostMapping("/addbuyer")
    public String addBuyer(@RequestBody buyer buyer) {
        buyer_Services.addbuyer(buyer);
        return "Buyer data added successfully";
    }

    @DeleteMapping("/deletebuyer/{id}")
    public String deleteBuyerById(@PathVariable Long id) {
        buyer_Services.deletebuyerById(id);
        return "Buyer data with ID " + id + " has been deleted.";
    }

    @PutMapping("/updatebuyer/{id}")
    public String updateBuyer(@PathVariable Long id, @RequestBody buyer updatedbuyer) {
        buyer_Services.updatebuyer(id, updatedbuyer);
        return "Buyer data with ID " + id + " has been updated.";
    }
}
