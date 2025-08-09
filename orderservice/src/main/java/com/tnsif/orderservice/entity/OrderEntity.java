package com.tnsif.orderservice.entity;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String orderNumber;
	private String customerName;
	private String status;
	private Double totalAmount;
	private Instant createdAt = Instant.now();

	// Getters & Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getOrderNumber() { return orderNumber; }
	public void setOrderNumber(String orderNumber) { this.orderNumber = orderNumber; }
	public String getCustomerName() { return customerName; }
	public void setCustomerName(String customerName) { this.customerName = customerName; }
	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }
	public Double getTotalAmount() { return totalAmount; }
	public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }
	public Instant getCreatedAt() { return createdAt; }
	public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
	}

