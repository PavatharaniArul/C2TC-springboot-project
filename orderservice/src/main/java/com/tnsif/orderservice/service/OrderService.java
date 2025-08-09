package com.tnsif.orderservice.service;

import org.springframework.stereotype.Service;
import java.util.*;

import com.tnsif.orderservice.entity.OrderEntity;
import com.tnsif.orderservice.repository.OrderRepository;

@Service
public class OrderService {
	private final OrderRepository repo;
	public OrderService(OrderRepository repo) { this.repo = repo; }

	public List<OrderEntity> findAll() { return repo.findAll(); }
	public Optional<OrderEntity> findById(Long id) { return repo.findById(id); }
	public OrderEntity save(OrderEntity o) { return repo.save(o); }
	public void deleteById(Long id) { repo.deleteById(id); }
	
}
 
