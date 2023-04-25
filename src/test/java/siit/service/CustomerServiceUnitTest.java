package siit.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;
import siit.dao.CustomerDao;
import siit.model.Customer;
import siit.model.exception.ValidationException;

class CustomerServiceUnitTest {

    private CustomerServiceImpl service = new CustomerServiceImpl();
    private CustomerDao customerDao = Mockito.mock(CustomerDao.class);

    @BeforeEach
    void injectDependencies() {
        //this is done using reflection like spring does
        //but can be done with setter or constructor
        ReflectionTestUtils.setField(service, "customerDao", customerDao);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "123456789012345678901234567890",
            "2",
            "235",
            "1111",
            "+212",
            "+111",
            "+123456789012345678901234567890"
    })
    void validPhoneNumbers_shouldBeSaved(String number) {
        Customer customer = new Customer();
        customer.setPhone(number);
        service.update(customer);

        Mockito.verify(customerDao).update(customer);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "abc",
            "a1b2",
            "123x",
            "",
            "+",
            "+12+",
            "123+",
            "017+9",
            "+1"
    })
    void invalidPhoneNumbers_shouldNotBeSavedAndThrowException(String number) {
        Customer customer = new Customer();
        customer.setPhone(number);

        Assertions.assertThrows(
                ValidationException.class,
                () -> service.update(customer));

        Mockito.verify(customerDao, Mockito.never()).update(customer);
    }

}
