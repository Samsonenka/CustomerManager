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

        List<Customer> customerList = customerRepo.findAll();

        model.put("customerList", customerList);
        return "index";
    }

    @GetMapping("/newCustomer")
    public String newCustomer(){

        return "newCustomerForm";
    }
}
