package com.example.pro1.repository;


import com.example.pro1.Entity.Produtcs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutcsRepsitory extends JpaRepository<Produtcs,Integer> {
}