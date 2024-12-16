package com.saiDeveloper.E_commerce_App.service;

import com.saiDeveloper.E_commerce_App.Entity.Order;
import com.saiDeveloper.E_commerce_App.Entity.User;
import com.saiDeveloper.E_commerce_App.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo repo;

    // -----------------find methods---------------------
    public List<Order> findAll(){
        return repo.findAll();
    }

    public Order findById(long id){
        return repo.findById(id).orElseThrow(()-> new RuntimeException("Order with id"+ id + "not found"));
    }

    public List<Order> findByUser(User user){
        return repo.findByUser(user);
    }

    // ------------add methods------------------o
    public Order addOrder(Order order){
        return repo.save(order);
    }



    //-------------delete methods------------------
    public void deleteOrder(long id){
        repo.findById(id).orElseThrow(()-> new RuntimeException("Order with id"+ id + "not found"));
        repo.deleteById(id);
    }


}
