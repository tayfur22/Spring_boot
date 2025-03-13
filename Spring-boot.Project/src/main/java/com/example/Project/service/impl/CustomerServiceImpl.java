package com.example.Project.service.impl;

import com.example.Project.entity.Customer;
import com.example.Project.repository.CustomerRepository;
import com.example.Project.service.BaseService;
import com.example.Project.service.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl  implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Customer> getById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    @Transactional
    public Customer save(Customer entity) {
        return customerRepository.save(entity);
    }

    @Override
    @Transactional
    public void deleteById(Long aLong) {
        customerRepository.deleteById(aLong);
    }
}
