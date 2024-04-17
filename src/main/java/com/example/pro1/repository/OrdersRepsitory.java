package com.example.pro1.repository;

import com.example.pro1.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrdersRepsitory extends JpaRepository<Orders,Integer> {
}