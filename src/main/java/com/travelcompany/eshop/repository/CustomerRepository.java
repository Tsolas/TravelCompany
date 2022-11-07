package com.travelcompany.eshop.repository;

import com.travelcompany.eshop.model.Customer;

public interface CustomerRepository extends Repository<Customer> {

    void updateAll(int customerId, Customer data);
}
