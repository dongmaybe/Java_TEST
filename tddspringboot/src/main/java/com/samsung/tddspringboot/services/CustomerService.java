package com.samsung.tddspringboot.services;

import com.samsung.tddspringboot.repository.models.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        for (Customer existingCustomer : customers) {
            if (existingCustomer.getEmail().equals(customer.getEmail())) {
                throw new RuntimeException("Email already exists");
            }
        }
        customers.add(customer);
    }


    public List<Customer> getAllCustomers() {
        return customers;
    }
}
