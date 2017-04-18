package com.example.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    private String champName;

    @ManyToOne
    private User user;

    public MainChamp() {
    }

    public String getChampName() {
        return champName;
    }

    public void setChampName(String champName) {
        this.champName = champName;
    }

    public int getId() {
        return id;
    }
}
