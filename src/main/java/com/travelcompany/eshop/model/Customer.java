package com.travelcompany.eshop.model;

import com.travelcompany.eshop.enums.CustomerCategory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
//    this counter works as an id incrementor
    private static int counter = 1;
    private int id;
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
        this.id = counter;
        counter++;
    }

    @Override
    public String toString() {
        return "Customer{" + "id= " + id + ", name= " + name + ", email= " + email + ", address= " + address + ", nationality= " + nationality + ", customerCategory= " + customerCategory + '}';
    }

}
