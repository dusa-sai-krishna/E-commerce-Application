package com.saiDeveloper.E_commerce_App.controller;

import com.saiDeveloper.E_commerce_App.Entity.Message;
import com.saiDeveloper.E_commerce_App.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/send/message")
    public String sendMessage(@ModelAttribute Message message, Model model) {
        messageService.addMessage(message);
        model.addAttribute("confirmation", "Message sent successfully!");
        return "contactUs";
    }

}
