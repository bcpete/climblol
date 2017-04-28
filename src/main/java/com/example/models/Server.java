package com.example.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brady on 4/7/17.
 */
@Entity
public class Server {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=2, max=4)
    public String name;

    @OneToMany
    @JoinColumn(name="server_id")
    private List<User> users;

    public Server() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void addUser(User user){
        users.add(user);
    }
}
