package com.roche.lis.domain.test.operation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.roche.lis.domain.test.operation.factory.AbstractFactory;
import com.roche.lis.domain.test.operation.strategy.ImmunologyOperationTwoStrategyImpl;
import com.roche.lis.domain.test.operation.strategy.TestTypeOperationStrategy;
import com.roche.lis.domainobject.TestType;

@RunWith(MockitoJUnitRunner.class)
public class TestOperationCalculatorTwoTest {
	
	@Mock
	private AbstractFactory abstractFactory;
	
	@Test
	public void executeTestOperationTwoCalculator() {
		final TestOperationCalculator testOperationCalculatorOne = new TestOperationCalculatorTwo(abstractFactory);
		final TestTypeOperationStrategy testTypeOperationStrategy = Mockito
				.spy(new ImmunologyOperationTwoStrategyImpl());
		Mockito.when(abstractFactory.getTestOperationFactory("cba")).thenReturn(testTypeOperationStrategy);
		testOperationCalculatorOne.calculate(new TestType());
		Mockito.verify(testTypeOperationStrategy).execute();
	}
	
}
