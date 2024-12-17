package com.saiDeveloper.E_commerce_App.repo;

import com.saiDeveloper.E_commerce_App.Entity.Message;
import com.saiDeveloper.E_commerce_App.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageRepo extends JpaRepository<Message,Long> {

    public Optional<Message> findByName(String name);

}
