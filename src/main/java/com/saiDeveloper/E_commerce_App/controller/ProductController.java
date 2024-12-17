package com.saiDeveloper.E_commerce_App.controller;

import com.saiDeveloper.E_commerce_App.Entity.Product;
import com.saiDeveloper.E_commerce_App.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("add/product")
    public String addProduct(){return "AddProduct";};

    @PostMapping("add/product")
    public String addProduct(@ModelAttribute("product") Product product){
        productService.addProduct(product);
        return "/admin/home";
    }

    @GetMapping("update/product/{id}")
    public String updateProduct(@PathVariable("id") Long id, Model model){
        try {
            model.addAttribute("product", productService.findById(id));
            return "UpdateProduct";
        } catch (Exception e) {
            model.addAttribute("error", e);
            return "UpdateProduct";
        }
    }

    @PostMapping("update/product")
    public String updateProduct(@ModelAttribute("product") Product product, Model model){
        try {
            productService.updateProduct(product);
            return "/admin/home";
        } catch (Exception e) {
            model.addAttribute("error", e);
            return "UpdateProduct";
        }
    }

    @DeleteMapping("delete/product/{id}")
    public String deleteProduct(@PathVariable("id") Long id,Model model){
        try {
            productService.deleteProduct(id);
            return "/admin/home";
        } catch (Exception e) {
            model.addAttribute("error", e);
            return "/admin/home";
        }
    }

}
