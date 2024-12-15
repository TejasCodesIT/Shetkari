package com.farmer_project.farmer_project.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmer_project.farmer_project.Models.product;
import com.farmer_project.farmer_project.Repositories.product_repository;

@Service
public class product_services {

    @Autowired
    private product_repository productRepository;

    public List<product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public product addProduct(product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public String updateproduct(Long id, product newproductData) {
        if (productRepository.existsById(id)) {
            newproductData.setId(id);  // Make sure the ID is set
            productRepository.save(newproductData); // Save the updated data
            return "product updated successfully";
        } else {
            return "product not found";
        }
    }

    public String getProductImageById(Long id) {
        Optional<product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            product product = productOptional.get();
            return product.getImage();  // Return the image (string)
        } else {
            return null;  // Return null if product not found
        }
    }
}
