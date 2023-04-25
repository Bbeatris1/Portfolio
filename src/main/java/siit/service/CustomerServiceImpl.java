package siit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.dao.CustomerDao;
import siit.model.Customer;
import siit.model.exception.ValidationException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public void update(Customer customer) {
        if ( ! isPhoneNumber(customer.getPhone())) {
            throw new ValidationException(
                    "Value " + customer.getPhone() + " is not a valid phone number");
        }
        customerDao.update(customer);
    }

    private boolean isPhoneNumber(String string) {
        int mintLength = string.startsWith("+") ? 3 : 1;
        if (string.length() < mintLength) {
            throw new ValidationException(
                    "Number must have at least 1 digit excluding prefix");
        }
        for (int i=0; i<string.length(); ++i) {
            char ch = string.charAt(i);
            if ( ! (Character.isDigit(ch) || ('+' == ch && i == 0))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerDao.getCustomerById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }
}
