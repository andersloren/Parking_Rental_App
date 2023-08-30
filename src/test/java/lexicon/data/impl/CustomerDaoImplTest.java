package lexicon.data.impl;

import lexicon.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDaoImplTest {

    private CustomerDaoImpl testObject;

    @BeforeEach
    public void setup() {
        testObject = CustomerDaoImpl.getInstance();
    }

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer("Test Testson", "123456");
        Customer createdCustomer = testObject.create(customer);

        Assertions.assertNotNull(createdCustomer);
    }

    @Test
    public void testFindById() {
        Customer customer = new Customer("Test Testson", "123456");
        Customer createdCustomer = testObject.create(customer);

        Assertions.assertNotNull(createdCustomer);
        Optional<Customer> customerOptional = testObject.find(createdCustomer.getId());
        assertTrue(customerOptional.isPresent());




    }
}