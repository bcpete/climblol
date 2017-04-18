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
    public String server;

    @OneToMany
    @JoinColumn(name="server_id")
    private List<User> users = new ArrayList<>();

    public Server() {
    }

    public Server(String server) {
        this.server = server;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getId() {
        return id;
    }
}
