package com.ijse.posdatabase.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.posdatabase.dto.OrderDTO;
import com.ijse.posdatabase.entity.Order;

@Service
public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order createOrder(OrderDTO orderDTO);

}
