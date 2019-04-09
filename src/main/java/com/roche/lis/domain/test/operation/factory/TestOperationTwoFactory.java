package com.roche.lis.domain.test.operation.factory;

import com.roche.lis.domain.test.operation.strategy.ImmunologyOperationTwoStrategyImpl;
import com.roche.lis.domain.test.operation.strategy.TestTypeOperationStrategy;

public class TestOperationTwoFactory implements AbstractFactory {

	@Override
	public TestTypeOperationStrategy getTestOperationFactory(final String testType) {
		return new ImmunologyOperationTwoStrategyImpl();
	}

}
