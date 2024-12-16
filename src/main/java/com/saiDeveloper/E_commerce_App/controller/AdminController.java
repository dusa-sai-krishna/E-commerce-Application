package com.saiDeveloper.E_commerce_App.controller;

import com.saiDeveloper.E_commerce_App.Entity.Admin;
import com.saiDeveloper.E_commerce_App.service.AdminService;
import com.saiDeveloper.E_commerce_App.service.OrderService;
import com.saiDeveloper.E_commerce_App.service.ProductService;
import com.saiDeveloper.E_commerce_App.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @GetMapping("/validate/admin")
    public String validateAdmin(@ModelAttribute("admin") Admin admin, Model model){

        if(adminService.validateAdmin(admin.getEmail(), admin.getPassword())){
            return "/admin/ home" ;
        }
        else{
            model.addAttribute("error", "Invalid credentials");
            return "Login";
        }
    }
    @GetMapping("/admin/home")
    public  String adminHomePage(Model model) {

        model.addAttribute("productList", productService.findAll());
        model.addAttribute("orderList", orderService.findAll());
        model.addAttribute("userList", userService.findAll());
        model.addAttribute("adminList", adminService.findAll());

        return "AdminHomePage";
    }

    @GetMapping("/add/admin")
    public String addAdmin(){
        // if anyone uses get mapping for add admin, it will redirect to same page.
        return "AddAdmin";
    }

    @PostMapping("/add/admin")
    public String addAdmin(@ModelAttribute("admin") Admin admin){

        adminService.addAdmin(admin);
        return "redirect:/admin/home";
    }
//---------------------update methods---------------------
    @GetMapping("/update/admin/{id}")
    public String updateAdmin(@PathVariable("id") long id, Model model){

        model.addAttribute("admin", adminService.findById(id));
        return "UpdateUser";
    }

    @PostMapping("/update/admin")
    public String updateAdmin(@ModelAttribute("admin") Admin admin){

        adminService.updateAdmin(admin);
        return "redirect:/admin/home";
    }
//---------------------delete methods---------------------
    @DeleteMapping("/delete/admin/{id}")
    public String deleteAdmin(@PathVariable("id") long id){

        adminService.deleteAdmin(id);
        return "redirect:/admin/home";
    }


}
