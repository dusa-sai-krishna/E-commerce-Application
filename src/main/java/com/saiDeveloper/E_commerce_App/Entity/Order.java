package com.saiDeveloper.E_commerce_App.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Scope("prototype")
public class Order {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long orderId;
    private String name;
    private double price;
    private int quantity;
    private Date date;
    private double amount;

    @ManyToOne// user can have many orders
    @JoinColumn(name = "userId") //foreign key is userId in orders table
    private User user;
}
