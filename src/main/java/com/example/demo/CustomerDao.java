package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerDao implements Dao<Customer>{
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Optional<Customer> get(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public Collection<Customer> getAll() {
        List<Customer> customers=new ArrayList<>();
        for (Customer customer : customerRepository.findAll()) customers.add(customer);
        return customers;
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        customerRepository.deleteAll();
    }

}
