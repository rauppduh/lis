package com.roche.lis.domain.order;

import java.util.Optional;

import com.roche.lis.domainobject.Order;
import com.roche.lis.domainobject.TestType;
import com.roche.lis.exception.OrderNotFoundException;

public interface OrderService {
	void save(Order order);

	void removeTestType(Long orderId, TestType testType) throws OrderNotFoundException;

	void addTestType(Long orderId, TestType testType) throws OrderNotFoundException;
	
	Optional<Order> findById(final Long orderId);
	
}
