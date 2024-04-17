package com.example.pro1.service;

import com.example.pro1.Entity.Customer;
import com.example.pro1.repository.CustomerRepsitory;

import java.util.List;
import java.util.Optional;


public class CustomerService {


    private CustomerRepsitory customerRepository;

    public CustomerService(CustomerRepsitory customerRepsitory) {
        this.customerRepository = customerRepsitory;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(int id) {
        return customerRepository.findById(id);
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(int id, Customer updatedCustomer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer existingCustomer = optionalCustomer.get();
            existingCustomer.setName(updatedCustomer.getName());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            return customerRepository.save(existingCustomer);
        } else {
            return null;
        }
    }

    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }
}
