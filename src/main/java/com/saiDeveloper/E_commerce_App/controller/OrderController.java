package com.saiDeveloper.E_commerce_App.controller;

import com.saiDeveloper.E_commerce_App.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

}
