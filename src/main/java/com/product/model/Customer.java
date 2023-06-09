package com.product.model;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Customer(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Customer() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
