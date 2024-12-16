package com.saiDeveloper.E_commerce_App.controller;

import com.saiDeveloper.E_commerce_App.Entity.Admin;
import com.saiDeveloper.E_commerce_App.Entity.Order;
import com.saiDeveloper.E_commerce_App.Entity.User;
import com.saiDeveloper.E_commerce_App.service.OrderService;
import com.saiDeveloper.E_commerce_App.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    private User user;
    @GetMapping("/add/user")
    public String addUser() {
        return "AddUser";
    }

    @PostMapping("/add/user")
    public String addUser(User user) {
        userService.addUser(user);
        return "Login";
    }

    @GetMapping("/update/user/{id}")
    public String updateUser(@PathVariable("id") long id, Model model){

        model.addAttribute("user", userService.findById(id));
        return "UpdateUser";
    }

    @PostMapping("/update/user")
    public String updateUser(@ModelAttribute("user") User user){

        userService.updateUser(user);
        return "redirect:/user/home";
    }

    @DeleteMapping("/delete/user/{id}")
    public String deleteAdmin(@PathVariable("id") long id){

        userService.deleteUser(id);
        return "redirect:/admin/home";
    }

    //----------------validate user
    @GetMapping("/user/login")
    public String validateUser(@ModelAttribute("user") User user, Model model){
        if(userService.validateUser(user.getEmail(), user.getPassword())){
            user = userService.findByEmail(user.getEmail());
            model.addAttribute("ordersList",orderService.findByUser(user));
            return "ProductPage";
        }
        else{
            model.addAttribute("error", "Invalid credentials");
            return "Login";
        }
    }

    // --------------------------Ordering Section--------------
    @GetMapping("/place/order")
    public String placeOrder(@ModelAttribute("order") Order order, Model model){
        double totalAmount = order.getPrice() * order.getQuantity();
        order.setAmount(totalAmount);
        order.setUser(user);
        order.setDate(new Date());
        orderService.addOrder(order);
        model.addAttribute("amount", totalAmount);
        return "OrderStatus";
    }





}
