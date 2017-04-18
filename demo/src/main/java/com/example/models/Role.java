package com.example.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brady on 4/7/17.
 */
@Entity
public class Role {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String position;

    @OneToMany
    @JoinColumn(name="role_id")
    private List<User> users = new ArrayList<>();

    public Role() {
    }

    public Role(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }
}
