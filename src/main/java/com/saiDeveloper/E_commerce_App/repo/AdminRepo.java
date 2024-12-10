package com.saiDeveloper.E_commerce_App.repo;

import com.saiDeveloper.E_commerce_App.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {

    public Optional<Admin> findByEmail(String email);
}
