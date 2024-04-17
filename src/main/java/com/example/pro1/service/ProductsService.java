package com.example.pro1.service;

import com.example.pro1.Entity.Produtcs;
import com.example.pro1.repository.ProdutcsRepsitory;

import java.util.List;
import java.util.Optional;

public class ProductsService {

    private ProdutcsRepsitory produtcsRepsitory;


    public ProductsService(ProdutcsRepsitory produtcsRepsitory) {
        this.produtcsRepsitory = produtcsRepsitory;
    }

    public List<Produtcs> getAllProdutcs() {
        return produtcsRepsitory.findAll();
    }

    public Optional<Produtcs> getProdutcsById(int id) {
        return produtcsRepsitory.findById(id);
    }

    public Produtcs addProdutcs(Produtcs produtcs) {
        return produtcsRepsitory.save(produtcs);
    }

    public Produtcs updateProdutcs(int id, Produtcs updatedProdutcs) {
        Optional<Produtcs> optionalProdutcs = produtcsRepsitory.findById(id);
        if (optionalProdutcs.isPresent()) {
            Produtcs existingProdutcs = optionalProdutcs.get();
            existingProdutcs.setName(updatedProdutcs.getName());
            existingProdutcs.setDescription(updatedProdutcs.getDescription());
            existingProdutcs.setPrice(updatedProdutcs.getPrice());
            existingProdutcs.setQuantity(updatedProdutcs.getQuantity());
            return produtcsRepsitory.save(existingProdutcs);
        } else {
            return null;
        }
    }

    public void deleteProdutcs(int id) {
        produtcsRepsitory.deleteById(id);
    }
}
