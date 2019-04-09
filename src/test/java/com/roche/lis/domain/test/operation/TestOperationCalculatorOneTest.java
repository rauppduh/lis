package com.roche.lis.domain.test.operation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.roche.lis.domain.test.operation.factory.AbstractFactory;
import com.roche.lis.domain.test.operation.strategy.MicrobiologyOperationOneStrategyImpl;
import com.roche.lis.domain.test.operation.strategy.TestTypeOperationStrategy;
import com.roche.lis.domainobject.TestType;

@RunWith(MockitoJUnitRunner.class)
public class TestOperationCalculatorOneTest {

	@Mock
	private AbstractFactory abstractFactory;

	@Test
	public void executeTestOperationOneCalculator() {
		final TestOperationCalculator testOperationCalculatorOne = new TestOperationCalculatorOne(abstractFactory);
		final TestTypeOperationStrategy testTypeOperationStrategy = Mockito
				.spy(new MicrobiologyOperationOneStrategyImpl());
		Mockito.when(abstractFactory.getTestOperationFactory("abc")).thenReturn(testTypeOperationStrategy);
		testOperationCalculatorOne.calculate(new TestType());
		Mockito.verify(testTypeOperationStrategy).execute();
	}

}
