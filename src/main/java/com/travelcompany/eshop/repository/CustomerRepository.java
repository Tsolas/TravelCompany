package com.travelcompany.eshop.repository;

import com.travelcompany.eshop.enums.CustomerCategory;
import com.travelcompany.eshop.model.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    List<Customer> customers = new ArrayList<>();

    //CRUD Iplementation
    // create
    public void insertCustomer(Customer customer) {
        customers.add(customer);
    }

    //read
    public void printCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    /**
     * This method deletes a Customer selected by its id.
     *
     * @param id
     */
    public void deleteCustomer(int id) {
        customers.removeIf(obj -> (obj.getId() == id));
    }

    /**
     * This method updates a customers info The name updateEntry is given as the
     * method currently only updates a whole entry and not one or more fields of
     * an entry
     *
     * @param id
     * @param name
     * @param email
     * @param address
     * @param nationality
     * @param customerCategory
     */
    public void updateEntry(int id, String name, String email, String address, String nationality, CustomerCategory customerCategory) {
        for (Customer cust : customers) {
            if (cust.getId() == id) {
                cust.setName(name);
                cust.setEmail(email);
                cust.setAddress(address);
                cust.setNationality(nationality);
                cust.setCustomerCategory(customerCategory);
            }
        }
    }
}
