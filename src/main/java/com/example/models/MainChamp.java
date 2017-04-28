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
public class MainChamp {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3)
    private String name;

    @ManyToMany
    private List<User> users;

    public MainChamp() {
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User newUser){
        users.add(newUser);
    }
}
