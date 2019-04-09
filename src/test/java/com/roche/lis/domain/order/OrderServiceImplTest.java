package com.roche.lis.domain.order;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.roche.lis.domain.order.OrderService;
import com.roche.lis.domain.order.OrderServiceImpl;
import com.roche.lis.domainobject.Order;
import com.roche.lis.domainobject.TestType;
import com.roche.lis.exception.OrderNotFoundException;
import com.roche.lis.infrastructure.repository.OrderRepository;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest {

	@Mock
	private OrderRepository orderRepository;
	private OrderService orderService;

	@Before
	public void setUp() {
		orderService = new OrderServiceImpl(orderRepository);
	}

	@Test
	public void saveOrder() {
		final Order order = new Order();
		orderService.save(order);
		Mockito.verify(orderRepository).save(order);
	}

	@Test
	public void changeOrderAddingNewTestType() {
		try {
			final Optional<Order> order = Optional.of(new Order());
			final TestType testType = new TestType();
			testType.setId(1L);
			Mockito.when(orderRepository.findById(1L)).thenReturn(order);
			orderService.addTestType(1L, testType);
			Mockito.verify(orderRepository).save(order.get());
			Assert.assertEquals(testType, order.get().getTestTypes().get(0));
		} catch (final OrderNotFoundException e) {
			Assert.fail();
		}
	}

	@Test
	public void changeOrderRemovingNewTestType() {
		try {
			final Optional<Order> order = Optional.of(new Order());
			final TestType testType = new TestType();
			testType.setId(1L);
			Mockito.when(orderRepository.findById(1L)).thenReturn(order);
			orderService.removeTestType(1L, testType);
			Mockito.verify(orderRepository).save(order.get());
			Assert.assertTrue(order.get().getTestTypes().isEmpty());
		} catch (final OrderNotFoundException e) {
			Assert.fail();
		}
	}

	@Test(expected = OrderNotFoundException.class)
	public void changeOrderAddingTestTypeFailsBecauseOrderDoesNotExist() throws OrderNotFoundException {
		final TestType testType = new TestType();
		testType.setId(1L);
		Mockito.when(orderRepository.findById(1L)).thenReturn(Optional.<Order>empty());
		orderService.addTestType(1L, testType);
	}

	@Test(expected = OrderNotFoundException.class)
	public void changeOrderRemovingTestTypeFailsBecauseOrderDoesNotExist() throws OrderNotFoundException {
		final TestType testType = new TestType();
		testType.setId(1L);
		Mockito.when(orderRepository.findById(1L)).thenReturn(Optional.<Order>empty());
		orderService.removeTestType(1L, testType);
	}

}
