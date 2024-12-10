package com.saiDeveloper.E_commerce_App.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Scope("prototype")
public class User {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long userId;

    private String name;
    private String email;
    private String password;

    //mappedBy = "user" is a field in Orders entity. We are specifying that this field is a foreign key in the Orders entity
    // and is responsible for maintaining this relationship. So when new orders comes in, it will be assigned to this user
    //cascadeType.ALL specify that all persistant operations like(insert, update, delete) should be cascaded.
    // That is if a user is deleted, then corresponding orders must be deleted.
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;
}
