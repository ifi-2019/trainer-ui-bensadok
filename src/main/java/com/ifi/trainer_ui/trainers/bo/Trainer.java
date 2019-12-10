package com.ifi.trainer_ui.trainers.bo;

import com.ifi.trainer_ui.trainers.bo.Pokemon;

import java.util.List;

public class Trainer {

    private String password;

    private String name;

    private List<Pokemon> team;

    private String picture;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pokemon> getTeam() {
        return team;
    }

    public void setTeam(List<Pokemon> team) {
        this.team = team;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPassword() {return this.password;}

    public void setPassword(String password) {this.password = password;}
}
