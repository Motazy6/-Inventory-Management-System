package com.example.pro1.service;

import com.example.pro1.Entity.Orders;
import com.example.pro1.repository.OrdersRepsitory;

import java.util.List;
import java.util.Optional;

public class OrdersService {

    private OrdersRepsitory ordersRepsitory;

    public OrdersService(OrdersRepsitory ordersRepository) {
        this.ordersRepsitory = ordersRepository;
    }

    public List<Orders> getAllOrders() {
        return ordersRepsitory.findAll();
    }

    public Optional<Orders> getOrdersById(int id) {
        return ordersRepsitory.findById(id);
    }

    public Orders addOrders(Orders orders) {
        return ordersRepsitory.save(orders);
    }

    public Orders updateOrders(int id, Orders updatedOrders) {
        Optional<Orders> optionalOrders = ordersRepsitory.findById(id);
        if (optionalOrders.isPresent()) {
            Orders existingOrders = optionalOrders.get();
            existingOrders.setDate(updatedOrders.getDate());
            existingOrders.setTotalPrice(updatedOrders.getTotalPrice());
            // Update any other fields as needed
            return ordersRepsitory.save(existingOrders);
        } else {
            // Handle the case where order with given id does not exist
            return null;
        }
    }

    public void deleteOrders(int id) {
        ordersRepsitory.deleteById(id);
    }
}
