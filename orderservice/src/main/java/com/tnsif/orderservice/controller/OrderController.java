package com.tnsif.orderservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.*;
import com.tnsif.orderservice.entity.OrderEntity;
import com.tnsif.orderservice.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	private final OrderService service;
	public OrderController(OrderService service) { this.service = service; }

	@GetMapping
	public List<OrderEntity> all() { return service.findAll(); }

	@GetMapping("/{id}")
	public ResponseEntity<OrderEntity> get(@PathVariable Long id) {
	return service.findById(id)
	.map(ResponseEntity::ok)
	.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<OrderEntity> create(@RequestBody OrderEntity o) {
	OrderEntity saved = service.save(o);
	return ResponseEntity.created(URI.create("/api/orders/" + saved.getId())).body(saved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<OrderEntity> update(@PathVariable Long id, @RequestBody OrderEntity o) {
	return service.findById(id).map(existing -> {
	existing.setOrderNumber(o.getOrderNumber());
	existing.setCustomerName(o.getCustomerName());
	existing.setStatus(o.getStatus());
	existing.setTotalAmount(o.getTotalAmount());
	service.save(existing);
	return ResponseEntity.ok(existing);
	}).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
	service.deleteById(id);
	return ResponseEntity.noContent().build();
	}
}
