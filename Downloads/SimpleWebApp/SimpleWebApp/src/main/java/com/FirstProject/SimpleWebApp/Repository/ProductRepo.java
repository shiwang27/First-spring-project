package com.FirstProject.SimpleWebApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FirstProject.SimpleWebApp.Model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

}
