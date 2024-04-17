package com.example.pro1.controller;

import com.example.pro1.Entity.Orders;
import com.example.pro1.service.OrdersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class OrdersController {

    OrdersService ordersService;
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Orders>> getAllOrders() {
        List<Orders> orders = ordersService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping("/orders")
    public ResponseEntity<Orders> createOrder(@RequestBody Orders order) {
        Orders createdOrders = ordersService.addOrders(order);
        return new ResponseEntity<>(createdOrders, HttpStatus.CREATED);

    }
    @PutMapping("/orders")
    public ResponseEntity<Orders> updateOrder(@PathVariable("id") int id, @RequestBody Orders order) {
        Orders updatedOrder = ordersService.updateOrders(id, order);
        if (updatedOrder != null) {
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/orders")
    public ResponseEntity<Orders> patchOrder(@PathVariable("id") int id, @RequestBody Orders order) {
        Orders patchedOrder = ordersService.updateOrders(id, order);
        if (patchedOrder != null) {
            return new ResponseEntity<>(patchedOrder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/orders")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") int id) {
        ordersService.deleteOrders(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

