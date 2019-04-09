package com.roche.lis.domain.test.operation;

import com.roche.lis.domainobject.TestType;

public class TestOperationServiceImpl implements TestOperationService {

	@Override
	public void execute(final TestType testType, final TestOperationCalculator testOperation) {
		testOperation.calculate(testType);
	}

}
