package com.example.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brady on 4/24/17.
 */
@Entity
public class UserRank {

    @GeneratedValue
    @Id
    private int id;

    @NotNull
    private String name;

    @OneToMany
    @JoinColumn(name="userrank_id")
    private List<User> users = new ArrayList<>();

    public UserRank() {
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
}
