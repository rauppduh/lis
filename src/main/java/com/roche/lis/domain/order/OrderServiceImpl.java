package com.roche.lis.domain.order;

import java.util.Optional;

import com.roche.lis.domainobject.Order;
import com.roche.lis.domainobject.TestType;
import com.roche.lis.exception.OrderNotFoundException;
import com.roche.lis.infrastructure.repository.OrderRepository;

public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;

	public OrderServiceImpl(final OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public void save(final Order order) {
		orderRepository.save(order);
	}

	@Override
	public void addTestType(final Long orderId, final TestType testType) throws OrderNotFoundException {
		final Optional<Order> optionalOrder = findById(orderId);
		if (!optionalOrder.isPresent()) {
			throw new OrderNotFoundException();
		}
		final Order order = optionalOrder.get();
		order.addTestType(testType);
		save(order);
	}

	@Override
	public void removeTestType(final Long orderId, final TestType testType)
			throws OrderNotFoundException {
		final Optional<Order> optionalOrder = findById(orderId);
		if (!optionalOrder.isPresent()) {
			throw new OrderNotFoundException();
		}
		final Order order = optionalOrder.get();
		order.removeTestType(testType);
		save(order);
	}

	@Override
	public Optional<Order> findById(final Long orderId) {
		return orderRepository.findById(orderId);
	}

}
