package com.product.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int aid;
    private String country;
    private String city;
    @OneToMany(mappedBy = "address",cascade = CascadeType.ALL)
    private List<Customer> customers;

    public Address(int aid, String country, String city, ArrayList<Customer> customers) {
        this.aid = aid;
        this.country = country;
        this.city = city;
        this.customers = customers;
    }

    public Address(String country, String city, ArrayList<Customer> customers) {
        this.country = country;
        this.city = city;
        this.customers = customers;
    }

    public Address() {
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }
}
