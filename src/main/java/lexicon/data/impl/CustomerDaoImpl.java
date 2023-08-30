package lexicon.data.impl;

import lexicon.data.CustomerDao;
import lexicon.data.sequencer.CustomerIdSequencer;
import lexicon.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class CustomerDaoImpl implements CustomerDao {

    // Fields
    private List<Customer> storage;

    // Singleton Design Pattern
    // Create an object of SingleObject
    private static CustomerDaoImpl instance;

    // make the constructor private so that this class cannot be instantiated
    private CustomerDaoImpl() {
        storage = new ArrayList<>();
    }

    public static CustomerDaoImpl getInstance() {
        if (instance == null) {
            instance = new CustomerDaoImpl();
        }
        return instance;
    }

    @Override
    public Customer create(Customer customer) {
        if (customer == null) throw new IllegalArgumentException("Customer Data is null");
        customer.setId(CustomerIdSequencer.nextId());
        storage.add(customer);
        return customer;
    }

    @Override
    public Optional<Customer> find(Integer id) {
        if (id == null ) throw new IllegalArgumentException("Id was null");
        for (Customer customer : storage) {
            if (customer.getId() == id) {
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(storage);
    }
}
