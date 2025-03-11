package com.example.Project.service;

import com.example.Project.entity.Customer;
import com.example.Project.repository.CustomerRepository;
import com.example.Project.service.impl.BaseServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CustomerService extends BaseServiceImpl {

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {

        super(customerRepository);

    }
}
