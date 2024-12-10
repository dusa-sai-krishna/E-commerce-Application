package com.saiDeveloper.E_commerce_App.repo;

import com.saiDeveloper.E_commerce_App.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    public Optional<Product> findByName(String name);
}
