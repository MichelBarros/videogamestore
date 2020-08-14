package com.videogamestore.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String director;

    @NotNull
    private String producer;

    @NotNull
    private String mark;

    @NotNull
    private int year;

    @NotNull
    private double price;

    @ManyToMany
    @JoinTable(name = "game_hero",
            joinColumns = @JoinColumn(name = "id_game"),
            inverseJoinColumns = @JoinColumn(name = "id_hero"))
    private Set<Hero> heros;

    @ManyToMany
    @JoinTable(name = "game_technology", joinColumns = @JoinColumn(name = "id_game"), inverseJoinColumns = @JoinColumn(name = "id_technology"))
    private Set<Technology> technologies;

    public Game() {

    }

    public Game(Long id, @NotNull String title, @NotNull String director, @NotNull String producer,
                @NotNull String mark, @NotNull int year, @NotNull double price) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.producer = producer;
        this.mark = mark;
        this.year = year;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTittle(String tittle) {
        this.title = tittle;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
