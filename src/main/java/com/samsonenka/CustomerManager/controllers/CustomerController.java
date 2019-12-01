package com.samsonenka.CustomerManager.controllers;

import com.samsonenka.CustomerManager.models.Customer;
import com.samsonenka.CustomerManager.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;

    @PostMapping("/postNewCustomer")
    public String postNewCustomer(Customer customer){

        customerRepo.save(customer);

        return "redirect:/";
    }

    @GetMapping("/deleteCustomer/{customerID}")
    public String editCustomer(@PathVariable int customerID){

        Customer customer = customerRepo.findById(customerID).get();
        customerRepo.delete(customer);

        return "redirect:/";
    }

    @PostMapping("/updateCustomer/{customerID}")
    public String updateCustomer(@PathVariable int customerID, Customer customer){

        Customer newCustomer = customerRepo.findById(customerID).get();

        newCustomer.setCustomerName(customer.getCustomerName());
        newCustomer.setCustomerSurname(customer.getCustomerSurname());
        newCustomer.setCustomerEmail(customer.getCustomerEmail());
        newCustomer.setCustomerAddress(customer.getCustomerAddress());
        newCustomer.setCustomerPhone(customer.getCustomerPhone());

        customerRepo.save(newCustomer);

        return "redirect:/";
    }

    @GetMapping("/findCustomer")
    public String findCustomer(@RequestParam String name, ModelMap modelMap){

        List<Customer> customerList = Customer.findCustomerByFullName(customerRepo.findAll(), name);

        if (customerList.isEmpty() || name.isEmpty()){
            return "redirect:/";
        }

        modelMap.put("customerList", customerList);

        return "index";
    }
}
