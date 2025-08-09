package com.tnsif.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnsif.orderservice.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

}
