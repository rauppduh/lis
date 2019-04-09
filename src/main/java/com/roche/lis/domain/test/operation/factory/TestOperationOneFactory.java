package com.roche.lis.domain.test.operation.factory;

import com.roche.lis.domain.test.operation.strategy.MicrobiologyOperationOneStrategyImpl;
import com.roche.lis.domain.test.operation.strategy.TestTypeOperationStrategy;

public class TestOperationOneFactory implements AbstractFactory  {

	@Override
	public TestTypeOperationStrategy getTestOperationFactory(final String testType) {
		return new MicrobiologyOperationOneStrategyImpl();
	}
	
}
