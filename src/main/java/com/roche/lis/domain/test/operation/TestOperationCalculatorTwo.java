package com.roche.lis.domain.test.operation;

import com.roche.lis.domain.test.operation.factory.AbstractFactory;
import com.roche.lis.domain.test.operation.strategy.TestTypeOperationStrategy;
import com.roche.lis.domainobject.TestType;

public class TestOperationCalculatorTwo implements TestOperationCalculator {

	private final AbstractFactory testOperationTwoFactory;

	public TestOperationCalculatorTwo(final AbstractFactory testOperationTwoFactory) {
		this.testOperationTwoFactory = testOperationTwoFactory;
	}

	@Override
	public void calculate(final TestType testType) {
		System.out.println(String.format(
				"This test for (%s) needs an implementation "
						+ "and as I did not have enough information it is kept empty like this",
				testType.getSubstanceTypeVO()));
		final TestTypeOperationStrategy testTypeOperationStrategy = testOperationTwoFactory
				.getTestOperationFactory("cba");
		testTypeOperationStrategy.execute();
	}
}
