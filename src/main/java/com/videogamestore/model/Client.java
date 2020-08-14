package com.videogamestore.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotNull
    private String firstName;

    @Column(name = "other_names")
    private String otherNames;

    @Column(name = "last_name")
    @NotNull
    private String lastName;

    @NotNull
    private short age;

    private Long cellphone;

    @NotNull
    private String email;

    public Client() {

    }

    public Client(Long id, @NotNull String firstName, String otherNames, @NotNull String lastName,
                  @NotNull short age, Long cellphone, @NotNull String email) {
        this.id = id;
        this.firstName = firstName;
        this.otherNames = otherNames;
        this.lastName = lastName;
        this.age = age;
        this.cellphone = cellphone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public Long getCellphone() {
        return cellphone;
    }

    public void setCellphone(Long cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
