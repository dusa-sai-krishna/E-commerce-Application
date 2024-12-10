package com.saiDeveloper.E_commerce_App.repo;

import com.saiDeveloper.E_commerce_App.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.saiDeveloper.E_commerce_App.Entity.Order;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

    public Optional<Order> findByUser(User user);
}
