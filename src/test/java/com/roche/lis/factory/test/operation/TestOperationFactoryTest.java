package com.roche.lis.factory.test.operation;

import org.junit.Assert;
import org.junit.Test;

import com.roche.lis.domain.test.operation.TestOperationCalculatorOne;
import com.roche.lis.domain.test.operation.TestOperationCalculatorTwo;
import com.roche.lis.domain.test.operation.factory.TestOperationCalculatorFactory;
import com.roche.lis.domainobject.TestType;
import com.roche.lis.domainvalue.TestOperationVO;

public class TestOperationFactoryTest {

	@Test
	public void getTestOperationOneInstance() {
		final TestType typeTest = new TestType();
		typeTest.setTestOperation(TestOperationVO.TEST_OPERATION_1);
		Assert.assertEquals(TestOperationCalculatorOne.class,
				TestOperationCalculatorFactory.getTestOperationCalculator(typeTest.getTestOperation()).getClass());
	}

	@Test
	public void getTestOperationTwoInstance() {
		final TestType typeTest = new TestType();
		typeTest.setTestOperation(TestOperationVO.TEST_OPERATION_2);
		Assert.assertEquals(TestOperationCalculatorTwo.class,
				TestOperationCalculatorFactory.getTestOperationCalculator(typeTest.getTestOperation()).getClass());
	}

}
