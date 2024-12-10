package com.saiDeveloper.E_commerce_App.service;

import com.saiDeveloper.E_commerce_App.Entity.User;
import com.saiDeveloper.E_commerce_App.repo.UserRepo;
import com.saiDeveloper.E_commerce_App.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepo repo;

    // -----------------find methods---------------------
    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(long id){
        return repo.findById(id).orElseThrow(()-> new RuntimeException("User with id"+ id + "not found"));
    }

    public User findByEmail(String email){
        return repo.findByEmail(email).orElseThrow(()-> new RuntimeException("User with email"+ email + "not found"));
    }

    // ------------add methods------------------o
    public User addUser(User user){
        return repo.save(user);
    }

    // ------------update methods------------------
    public User updateUser(User user){
        repo.findById(user.getUserId()).orElseThrow(()-> new RuntimeException("User with id"+ user.getUserId() + "not found"));
        return repo.save(user);
    }

    //-------------delete methods------------------
    public void deleteUser(long id){
        repo.findById(id).orElseThrow(()-> new RuntimeException("User with id"+ id + "not found"));
        repo.deleteById(id);
    }

    // -----------------validate methods---------------------
    // returns false if any exceptions raised. If not true
    public boolean validateUser(String email, String password){

        try {
            User User = findByEmail(email);
            if(!User.getPassword().equals(password)){
                throw new RuntimeException("Invalid credentials");
            }
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

}
