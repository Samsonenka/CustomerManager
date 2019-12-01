package com.samsonenka.CustomerManager.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerID;

    private String customerName;
    private String customerSurname;
    private String customerEmail;
    private String customerAddress;
    private int customerPhone;

    public Customer() {
    }

    public Customer(String customerName, String customerSurname, String customerEmail, String customerAddress, int customerPhone) {
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
    }

    public static List<Customer> findCustomerByFullName(List<Customer> all, String name) {

        String customerFullName;
        List<Customer> customerList = new ArrayList<>();

        for (Customer customer: all){
            customerFullName = customer.customerName + " " + customer.customerSurname;
            if (customerFullName.equals(name)){
                customerList.add(customer);
            }
        }
        return customerList;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public int getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(int customerPhone) {
        this.customerPhone = customerPhone;
    }
}
