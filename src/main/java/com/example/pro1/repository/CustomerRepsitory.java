package com.example.pro1.repository;

import com.example.pro1.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepsitory extends JpaRepository<Customer,Integer> {

}
