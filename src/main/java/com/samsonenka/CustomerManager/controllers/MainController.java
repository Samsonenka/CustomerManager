package com.samsonenka.CustomerManager.controllers;

import com.samsonenka.CustomerManager.models.Customer;
import com.samsonenka.CustomerManager.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private CustomerRepo customerRepo;

    @GetMapping("/")
    public String index(ModelMap model){

//        Customer customer = new Customer("Anna", "Ross", "anna19ross19@Gmail.com", "Rivadavia 2691 Piso 01", 784587111);
//        customerRepo.save(customer);

        List<Customer> customerList = customerRepo.findAll();

        model.put("customerList", customerList);
        return "index";
    }
}
