package com.saiDeveloper.E_commerce_App.service;

import com.saiDeveloper.E_commerce_App.Entity.Product;
import com.saiDeveloper.E_commerce_App.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    @Autowired
    private ProductRepo repo;

    // -----------------find methods---------------------
    public List<Product> findAll(){
        return repo.findAll();
    }

    public Product findById(long id){
        return repo.findById(id).orElseThrow(()-> new RuntimeException("Product with id"+ id + "not found"));
    }

    public Product findByName(String name){
        return repo.findByName(name).orElseThrow(()-> new RuntimeException("Product with name"+ name + "not found"));
    }

    // ------------add methods------------------o
    public Product addProduct(Product product){
        return repo.save(product);
    }

    // ------------update methods------------------
    public Product updateProduct(Product product){
        repo.findById(product.getProductId()).orElseThrow(()-> new RuntimeException("Product with id"+ product.getProductId() + "not found"));
        return repo.save(product);
    }

    //-------------delete methods------------------
    public void deleteProduct(long id){
        repo.findById(id).orElseThrow(()-> new RuntimeException("Product with id"+ id + "not found"));
        repo.deleteById(id);
    }


}
    

