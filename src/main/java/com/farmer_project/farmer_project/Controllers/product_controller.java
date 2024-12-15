package com.farmer_project.farmer_project.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;


import com.farmer_project.farmer_project.Models.product;
import com.farmer_project.farmer_project.Services.product_services;

@RestController
public class product_controller {



    @Autowired
    private product_services productService;

    @GetMapping("getproduct")
    public List<product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("getproduct/{id}")
    public Optional<product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

//     @PostMapping("addproduct")
// public String addProduct(@RequestParam String name,
//                          @RequestParam String description,
//                          @RequestParam Double price,
//                          @RequestParam MultipartFile image) {
//     try {
//         // Convert the image to byte[]
//         product product = new product( null, name, description, price, image.getBytes());
//         productService.addProduct(product);
//         return "Product added successfully";
//     } catch (Exception e) {
//         return "Failed to add product: " + e.getMessage();
//     }
// }

@PostMapping("addproduct")
    public String addproduct(@RequestBody product product) {
         productService.addProduct(product);
         return "product data added sucessfully";
    }


    @DeleteMapping("deleteproduct/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "Product with ID " + id + " has been deleted.";
    }

    @PutMapping("updateproduct/{id}")
    public String updateproduct(@PathVariable Long id, @RequestBody product updatedProduct) {
    productService.updateproduct(id, updatedProduct);
    return "Product with ID " + id + " has been updated successfully.";
}

@GetMapping("getproductimage/{id}")
    public ResponseEntity<String> getProductImage(@PathVariable Long id) {
        String image = productService.getProductImageById(id);
        if (image != null) {
            return ResponseEntity.ok().body(image);  // Return the image URL/Base64 string
        } else {
            return ResponseEntity.notFound().build();  // Return 404 if image not found
        }
    }

    // @GetMapping("getproductimage/{id}")
    // public String getProductImage(@PathVariable Long id) {
    //     productService.getProductImageById(id);
    //     return "Product image by ID " + id + " found successfully.";
    // }

    
}

    

