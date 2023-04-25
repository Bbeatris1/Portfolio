package siit.service;

import siit.model.Customer;

import java.util.List;

public interface CustomerService {

    void update(Customer customer);

    Customer getCustomerById(int id);

    List<Customer> getAllCustomers();
}
