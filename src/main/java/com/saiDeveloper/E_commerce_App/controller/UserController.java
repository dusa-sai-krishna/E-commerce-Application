package com.saiDeveloper.E_commerce_App.controller;

import com.saiDeveloper.E_commerce_App.Entity.Admin;
import com.saiDeveloper.E_commerce_App.Entity.Order;
import com.saiDeveloper.E_commerce_App.Entity.Product;
import com.saiDeveloper.E_commerce_App.Entity.User;
import com.saiDeveloper.E_commerce_App.service.OrderService;
import com.saiDeveloper.E_commerce_App.service.ProductService;
import com.saiDeveloper.E_commerce_App.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;



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
    public String updateUser(@PathVariable("id") long id, Model model) {

        model.addAttribute("user", userService.findById(id));
        return "UpdateUser";
    }

    @PostMapping("/update/user")
    public String updateUser(@ModelAttribute("user") User user) {

        userService.updateUser(user);
        return "redirect:/admin/home";
    }

    @GetMapping("/delete/user/{id}")
    public String deleteAdmin(@PathVariable("id") long id) {

        userService.deleteUser(id);
        return "redirect:/admin/home";
    }

    //----------------validate user
    @PostMapping("/user/login")
    public String validateUser(String email, String password, Model model, HttpSession session) {
        if (userService.validateUser(email, password)) {
            User user = userService.findByEmail(email);
            session.setAttribute("userId", user.getUserId());

            return "redirect:/user/home";
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "Login";
        }
    }

    @GetMapping("/user/home")
    public String userHome(Model model,HttpSession session) {
        User loggedUser = userService.findById((long) session.getAttribute("userId"));
        model.addAttribute("ordersList", orderService.findByUser(loggedUser));

        return "BuyProductPage";
    }



    //-------------------product search ------------------------------
    @PostMapping("/product/search")
    public String productSearch(String name, Model model, HttpSession session) {
        long userId = (long) session.getAttribute("userId");

        try {
            Product product = productService.findByName(name);
            model.addAttribute("product", product);
            model.addAttribute("ordersList", orderService.findByUser(userService.findById(userId)));
            return "BuyProductPage";
        } catch (Exception e) {
            model.addAttribute("messsageError", e);
            model.addAttribute("ordersList", orderService.findByUser(userService.findById(userId)));
            return "BuyProductPage";

        }


    }
    // --------------------------Ordering Section--------------
    @PostMapping("/place/order")
    public String placeOrder(@ModelAttribute("order") Order order, Model model,HttpSession session) {
        long userId = (long) session.getAttribute("userId");
        double totalAmount = order.getPrice() * order.getQuantity();
        order.setAmount(totalAmount);
        order.setUser(userService.findById(userId));
        order.setDate(new Date());
        orderService.addOrder(order);

        model.addAttribute("messageSuccess", "Order placed successfully");
        model.addAttribute("ordersList", orderService.findByUser(userService.findById(userId)));
        return "redirect:/user/home";
    }


}
