package com.ijse.posdatabase.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.posdatabase.dto.OrderDTO;
import com.ijse.posdatabase.entity.Item;
import com.ijse.posdatabase.entity.Order;
import com.ijse.posdatabase.repository.ItemRepository;
import com.ijse.posdatabase.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order createOrder(OrderDTO orderDTO) {
       
        Order order = new Order();

        List<Long> items = orderDTO.getItems();

        Set<Item> itemsSet = new HashSet<>();

        order.setTotal(0.0);

        for (Long itemId : items) {
            Item item = itemRepository.findById(itemId).orElse(null);

            if(item != null && item.getQty() != 0) {
                itemsSet.add(item);
                order.setTotal(order.getTotal() + item.getPrice());

            }
        }

        order.setOrderTime(LocalDateTime.now());
        order.setItems(itemsSet);

        return orderRepository.save(order);
    }
    
}
