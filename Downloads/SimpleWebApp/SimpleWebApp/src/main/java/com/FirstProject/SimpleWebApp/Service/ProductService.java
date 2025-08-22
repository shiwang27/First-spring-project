package com.FirstProject.SimpleWebApp.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.stereotype.Service;

import com.FirstProject.SimpleWebApp.Model.Product;

@Service
public class ProductService {

    List<Product> products = Arrays.asList(
        new Product(101,"iphone",50000),
        new Product(102,"canon camera",70000),
        new Product(103,"shure mic",10000));

    public List<Product> getProducts(){
        return products;
        
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product getProductById(int prodId) {
        return products.stream()
                .filter(p -> p.getProdId() == prodId)
                .findFirst().get();
        
    }

    

}
