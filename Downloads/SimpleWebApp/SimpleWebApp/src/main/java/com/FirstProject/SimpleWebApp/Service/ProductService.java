package com.FirstProject.SimpleWebApp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.FirstProject.SimpleWebApp.Model.Product;

@Service
public class ProductService {

    // List to hold our products
    private final List<Product> products = new ArrayList<>();

    public ProductService() {
        // CORRECT SYNTAX: Just pass the values in the correct order
        products.add(new Product(101, "Laptop", 75000));
        products.add(new Product(102, "Mouse", 1200));
        products.add(new Product(103, "Keyboard", 2500));
    }

    // Method to get all products
    public List<Product> getProducts() {
        return products;
    }

    // --- THIS IS THE FULLY CORRECTED METHOD ---
    public Product getProductById(int prodId) {
        // The stream operations must be chained in a single statement
        Optional<Product> optionalProduct = products.stream()
                .filter(p -> p.getProdId() == prodId)
                .findFirst();

        // Check if the product was found. If not, throw an exception
        // that Spring Boot will automatically convert to a 404 Not Found response.
        if (optionalProduct.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with ID " + prodId + " not found");
        }

        // If we get here, the product exists, so we can safely call .get()
        return optionalProduct.get();
    }

    public void addProduct(Product prod) {
        products.add(prod);
    }

    public void updateProduct(Product prod) {
        int index=0;
        for(int i=0;i<products.size();i++)
            if(products.get(i).getProdId()== prod.getProdId())
                index= i ;

        products.set(index,prod);
    }

    public void deleteProduct(int prodId) {
        int index=0;
        for(int i=0;i<products.size();i++)
            if(products.get(i).getProdId()== prodId)
                index= i ;

        
        products.remove(index);
    }
}
