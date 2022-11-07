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

    /**
     * This method contains hard-coded mock data to be added in customers list
     * could be updated to get data from external sources
     */
    public void populateCustomers() {
        customers.add(new Customer("Maria Iordanou", "miordanou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL));
        customers.add(new Customer("Dimitriou Dimitrios", "ddimitriou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL));
        customers.add(new Customer("Ioannis Ioannou", "iioannou@mail.com", "Athens", "Greek", CustomerCategory.BUSINESS));
        customers.add(new Customer("Antonio Molianri", "amolinari@mail.com", "Milan", "Italian", CustomerCategory.INDIVIDUAL));
        customers.add(new Customer("Frederico Rossi", "frossi@mail.com", "Milan", "Italian", CustomerCategory.INDIVIDUAL));
        customers.add(new Customer("Mario Conti", "mconti@mail.com", "Rome", "Italian", CustomerCategory.BUSINESS));
        customers.add(new Customer("Nathan Martin", "nmartin@mail.com", "Lyon", "French", CustomerCategory.BUSINESS));
        customers.add(new Customer("Enzo Collin", "ecollin@mail.com", "Lyon", "French", CustomerCategory.INDIVIDUAL));
        customers.add(new Customer("Frederic Michel", "fmichel@mail.com", "Athens", "French", CustomerCategory.INDIVIDUAL));
        customers.add(new Customer("Catalina Alvares", "calvares@mail.com", "Madrid", "Spanish", CustomerCategory.BUSINESS));
        customers.add(new Customer("Axel Cortez", "acortez@mail.com", "Barcelona", "Spanish", CustomerCategory.BUSINESS));
        customers.add(new Customer("Karl Schwarz", "kschwarz@mail.com", "Berlin", "German", CustomerCategory.BUSINESS));
        customers.add(new Customer("Petra Muller", "pmuller@mail.com", "Munich", "German", CustomerCategory.INDIVIDUAL));
        customers.add(new Customer("Joao Miguel", "jmiguel@mail.com", "Lisbon", "Portugese", CustomerCategory.BUSINESS));
        customers.add(new Customer("Alda Costa", "acosta@mail.com", "Porto", "Portugese", CustomerCategory.INDIVIDUAL));

    }

}
