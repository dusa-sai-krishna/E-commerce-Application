package com.saiDeveloper.E_commerce_App.service;

import com.saiDeveloper.E_commerce_App.Entity.Admin;
import com.saiDeveloper.E_commerce_App.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepo repo;

    // -----------------find methods---------------------
    public List<Admin> findAll(){
        return repo.findAll();
    }

    public Admin findById(long id){
        return repo.findById(id).orElseThrow(()-> new RuntimeException("Admin with id"+ id + "not found"));
    }

    public Admin findByEmail(String email){
        return repo.findByEmail(email).orElseThrow(()-> new RuntimeException("Admin with email"+ email + "not found"));
    }

    // ------------add methods------------------o
    public Admin addAdmin(Admin admin){
        return repo.save(admin);
    }

    // ------------update methods------------------
    public Admin updateAdmin(Admin admin){
        repo.findById(admin.getAdminId()).orElseThrow(()-> new RuntimeException("Admin with id"+ admin.getAdminId() + "not found"));
        return repo.save(admin);
    }

    //-------------delete methods------------------
    public void deleteAdmin(long id){
        repo.findById(id).orElseThrow(()-> new RuntimeException("Admin with id"+ id + "not found"));
        repo.deleteById(id);
    }

    // -----------------validate methods---------------------
    // returns false if any exceptions raised. If not true
    public boolean validateAdmin(String email, String password){

        try {
            Admin admin = findByEmail(email);
            if(!admin.getPassword().equals(password)){
                throw new RuntimeException("Invalid credentials");
            }
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

}
