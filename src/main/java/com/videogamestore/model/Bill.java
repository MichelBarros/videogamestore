package com.videogamestore.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Set;

@Entity
@Table(name = "bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_client", unique = true)
    @NotNull
    private Client client;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "rent_date")
    @NotNull
    private Calendar rentDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "return_date")
    @NotNull
    private Calendar returnDate;

    private double total;

    @ManyToMany
    @JoinTable(name = "rent",
        joinColumns = @JoinColumn(name = "id_bill"),
        inverseJoinColumns = @JoinColumn(name = "id_game"))
    private Set<Game> games;

    public Bill() {

    }

    public Bill(Long id, @NotNull Client client, @NotNull Calendar rentDate, @NotNull Calendar returnDate, double total) {
        this.id = id;
        this.client = client;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Calendar getRentDate() {
        return rentDate;
    }

    public void setRentDate(Calendar rentDate) {
        this.rentDate = rentDate;
    }

    public Calendar getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Calendar returnDate) {
        this.returnDate = returnDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
