package com.roche.lis.domain.test.operation.factory;

import com.roche.lis.domain.test.operation.TestOperationCalculator;
import com.roche.lis.domain.test.operation.TestOperationCalculatorOne;
import com.roche.lis.domain.test.operation.TestOperationCalculatorTwo;
import com.roche.lis.domainvalue.TestOperationVO;

public class TestOperationCalculatorFactory {

	public static TestOperationCalculator getTestOperationCalculator(final TestOperationVO testOperationVO) {
		switch (testOperationVO) {
		case TEST_OPERATION_1:
			return new TestOperationCalculatorOne(TestOperationAbstractFactory.getTestOperationAbstractFactory("ONE"));
		case TEST_OPERATION_2:
			return new TestOperationCalculatorTwo(TestOperationAbstractFactory.getTestOperationAbstractFactory("TWO"));
		default:
			throw new IllegalArgumentException(String.format("Not valid type of test: %s", testOperationVO));
		}
	}

}
