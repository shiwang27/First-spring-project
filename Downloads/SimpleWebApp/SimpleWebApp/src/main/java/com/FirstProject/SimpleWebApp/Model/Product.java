package com.FirstProject.SimpleWebApp.Model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Component
public class Product {

    
    private int prodId;
    private String prodName;
    private int price;

    public Product() {
    }



    public Product(int prodId, String prodName, int price) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.price = price;
    }
    public int getProductId() {
        return prodId;
    }
    public String getProdName() {
        return prodName;
    }
    public int getPrice() {
        return price;
    }



    public int getProdId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProdId'");
    }

    

}
