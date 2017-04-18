package com.example.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brady on 4/7/17.
 */
@Entity
public class UserType {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String type;

    @OneToMany
    @JoinColumn(name="usertype_id")
    private List<User> users = new ArrayList<>();

    public UserType(){}

    public UserType(String type) {
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }
}
