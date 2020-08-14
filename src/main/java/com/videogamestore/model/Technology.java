package com.videogamestore.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "technology")
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String technology;

    public Technology() {

    }

    public Technology(Long id, @NotNull String technology) {
        this.id = id;
        this.technology = technology;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

}
