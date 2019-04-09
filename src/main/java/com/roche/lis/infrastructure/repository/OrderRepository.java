package com.roche.lis.infrastructure.repository;

import java.util.Optional;

import com.roche.lis.domainobject.Order;

public interface OrderRepository {
	
	public void save(Order order);

	public Optional<Order> findById(Long orderId);
	
}
