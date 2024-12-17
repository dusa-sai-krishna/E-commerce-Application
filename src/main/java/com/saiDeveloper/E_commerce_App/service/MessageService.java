package com.saiDeveloper.E_commerce_App.service;

import com.saiDeveloper.E_commerce_App.Entity.Message;
import com.saiDeveloper.E_commerce_App.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {



    @Autowired
    private MessageRepo repo;

    // -----------------find methods---------------------
    public List<Message> findAll(){
        return repo.findAll();
    }

    public Message findById(long id){
        return repo.findById(id).orElseThrow(()-> new RuntimeException("Message with id"+ id + "not found"));
    }

    public Message findByName(String name){
        return repo.findByName(name).orElseThrow(()-> new RuntimeException("Message with name"+ name + "not found"));
    }

    // ------------add methods------------------o
    public Message addMessage(Message message){
        return repo.save(message);
    }

    // ------------update methods------------------
    public Message updateMessage(Message message){
        repo.findById(message.getId()).orElseThrow(()-> new RuntimeException("Message with id"+ message.getId() + "not found"));
        return repo.save(message);
    }

    //-------------delete methods------------------
    public void deleteMessage(long id){
        repo.findById(id).orElseThrow(()-> new RuntimeException("Message with id"+ id + "not found"));
        repo.deleteById(id);
    }

}
