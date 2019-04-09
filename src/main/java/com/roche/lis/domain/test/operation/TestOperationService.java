package com.roche.lis.domain.test.operation;

import com.roche.lis.domainobject.TestType;

public interface TestOperationService {
	
	void execute(final TestType testType, final TestOperationCalculator testOperation);
	
}
