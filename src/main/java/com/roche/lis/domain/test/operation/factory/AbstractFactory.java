package com.roche.lis.domain.test.operation.factory;

import com.roche.lis.domain.test.operation.strategy.TestTypeOperationStrategy;

public interface AbstractFactory {
	
	public TestTypeOperationStrategy getTestOperationFactory(final String testType);
	
}
