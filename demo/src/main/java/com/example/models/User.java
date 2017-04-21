package com.example.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brady on 4/7/17.
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String userRank;

    @NotNull
    @Size(min = 3)
    private String username;

    @ManyToOne
    private Server server;

    @ManyToOne
    private Role role;

    @ManyToMany(mappedBy="users")
    private List<MainChamp> mainChamps;

    @NotNull
    private String password;

    @NotNull
    private String opGGLink;

    @NotNull
    private String discordLink;

    @ManyToOne
    private UserType userType;

    @NotNull
    @Size(max = 500)
    private String aboutMe;

    public User() {
    }

    public User(String username, Server server, Role role, ArrayList<MainChamp> mainChamps,
                String password, String opGGLink, String discordLink, UserType userType,
                String aboutMe) {
        this.username = username;
        this.server = server;
        this.role = role;
        this.mainChamps = mainChamps;
        this.password = password;
        this.opGGLink = opGGLink;
        this.discordLink = discordLink;
        this.userType = userType;
        this.aboutMe = aboutMe;
    }

    public String getUserRank() {
        return userRank;
    }

    public void setUserRank(String userRank) {
        this.userRank = userRank;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<MainChamp> getMainChamps() {
        return mainChamps;
    }

    public void setMainChamps(List<MainChamp> mainChamps) {
        this.mainChamps = mainChamps;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOpGGLink() {
        return opGGLink;
    }

    public void setOpGGLink(String opGGLink) {
        this.opGGLink = opGGLink;
    }

    public String getDiscordLink() {
        return discordLink;
    }

    public void setDiscordLink(String discordLink) {
        this.discordLink = discordLink;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }
}
