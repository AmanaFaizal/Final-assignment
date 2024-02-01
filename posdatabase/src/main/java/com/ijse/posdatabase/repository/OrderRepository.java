package com.ijse.posdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.posdatabase.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
