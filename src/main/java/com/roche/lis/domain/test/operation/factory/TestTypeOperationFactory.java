package com.roche.lis.domain.test.operation.factory;

import com.roche.lis.domain.test.operation.strategy.MicrobiologyOperationOneStrategyImpl;
import com.roche.lis.domain.test.operation.strategy.TestTypeOperationStrategy;

public class TestTypeOperationFactory {
	
	public static TestTypeOperationStrategy getTestTypeOperation() {
		return new MicrobiologyOperationOneStrategyImpl();
	}
	
}
