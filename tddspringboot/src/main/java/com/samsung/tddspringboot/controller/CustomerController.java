package com.samsung.tddspringboot.controller;

import com.samsung.tddspringboot.repository.models.Customer;
import com.samsung.tddspringboot.services.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {

    private CustomerService customerService = new CustomerService();

    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute Customer customer, Model model) {

            customerService.addCustomer(customer);
            model.addAttribute("customers", customerService.getAllCustomers());

        return "index";
    }


    @GetMapping("/")
    public String getCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "index";
    }


    @GetMapping("/customers")
    @ResponseBody
    public List<Customer> getCustomersApi() {
        return customerService.getAllCustomers();
    }
}
