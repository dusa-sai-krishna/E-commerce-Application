package com.saiDeveloper.E_commerce_App.repo;

import com.saiDeveloper.E_commerce_App.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    public Optional<User> findByEmail(String email);
}
