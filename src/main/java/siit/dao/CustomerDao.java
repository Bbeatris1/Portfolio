package siit.dao;


import siit.model.Customer;

import java.util.List;

public interface CustomerDao {

    void update(Customer customer);

    Customer getCustomerById(int id);

    List<Customer> getAllCustomers();
}
