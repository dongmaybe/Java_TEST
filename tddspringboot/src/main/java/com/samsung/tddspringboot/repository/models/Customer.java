package com.samsung.tddspringboot.repository.models;


import java.time.LocalDateTime;

public class Customer {
    private String name;
    private String number;
    private String email;
    private LocalDateTime createdAt;

    public Customer(String name, String number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.createdAt = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
