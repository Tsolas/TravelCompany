package com.travelcompany.eshop.repository.impl;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.repository.CustomerRepository;

public class CustomerRepositoryImpl extends RepositoryImpl<Customer> implements CustomerRepository {

    @Override
    public void updateAll(int customerId, Customer data) {
        Customer customer = read(customerId);

        if (customer != null) {
            customer.setName(data.getName());
            customer.setEmail(data.getEmail());
            customer.setAddress(data.getAddress());
            customer.setNationality(data.getNationality());
            customer.setCustomerCategory(data.getCustomerCategory());
        }
    }

}
