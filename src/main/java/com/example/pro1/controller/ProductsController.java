package com.example.pro1.controller;

import com.example.pro1.Entity.Produtcs;
import com.example.pro1.service.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ProductsController {

    ProductsService productsService;
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/produtcs")
    public ResponseEntity<List<Produtcs>> getAllProducts() {
        List<Produtcs> produtcs = productsService.getAllProdutcs();
        return ResponseEntity.ok(produtcs);
    }

    @PostMapping("/Produtcs")
    public ResponseEntity<Produtcs> getProductById(@RequestBody Produtcs produtcs) {
        Produtcs createdProdutcs = productsService.addProdutcs(produtcs);
        return new ResponseEntity(createdProdutcs, HttpStatus.OK);

    }
    @PutMapping("/Produtcs")
    public ResponseEntity<Produtcs> updateProdutcs(@PathVariable("id") int id, @RequestBody Produtcs product) {
        Produtcs updatedProduct = productsService.updateProdutcs(id, product);
        if (updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/Produtcs")
    public ResponseEntity<Produtcs> patchProdutcs(@PathVariable("id") int id, @RequestBody Produtcs product) {
        Produtcs patchedProduct = productsService.updateProdutcs(id, product);
        if (patchedProduct != null) {
            return new ResponseEntity<>(patchedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/Produtcs")
    public ResponseEntity<Void> deleteProdutcs(@PathVariable("id") int id) {
        productsService.deleteProdutcs(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
