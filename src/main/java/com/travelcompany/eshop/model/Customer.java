package com.travelcompany.eshop.model;

import com.travelcompany.eshop.enums.CustomerCategory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {

    private static int id = 0;
    private String name;
    private String email;
    private String address;
    private String nationality;
    private CustomerCategory customerCategory;

    public Customer(String name, String email, String address, String nationality, CustomerCategory customerCategory) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.nationality = nationality;
        this.customerCategory = customerCategory;
        id++;
    }

    @Override
    public String toString() {
        return "Customer{" + "id= " + id + ", name= " + name + ", email= " + email + ", address= " + address + ", nationality= " + nationality + ", customerCategory= " + customerCategory + '}';
    }

}
