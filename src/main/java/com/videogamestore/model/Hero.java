package com.videogamestore.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "hero")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String hero;

    public Hero() {

    }

    public Hero(Long id, @NotNull String hero) {
        this.id = id;
        this.hero = hero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHero() {
        return hero;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }
}
