package com.saiDeveloper.E_commerce_App.controller;


import com.saiDeveloper.E_commerce_App.Entity.Admin;
import com.saiDeveloper.E_commerce_App.Entity.Message;
import com.saiDeveloper.E_commerce_App.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;
    @GetMapping("/home")
    public String homePage() {
        return "HomePage";
    }

    @GetMapping("/products")
    public String productsPage(Model model) {
        model.addAttribute("productList", productService.findAll());
        return "Products";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("admin", new Admin());
        return "Login";
    }

    @GetMapping("/aboutUs")
    public String aboutUsPage() {
        return "AboutUs";
    }

    @GetMapping("/contactUs")
    public String contactPage() {
        return "ContactUs";
    }


}
