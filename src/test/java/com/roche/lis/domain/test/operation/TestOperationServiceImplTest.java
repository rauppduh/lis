package com.roche.lis.domain.test.operation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.roche.lis.domainobject.Biochemistry;
import com.roche.lis.domainobject.TestType;
import com.roche.lis.domainvalue.SubstanceTypeVO;
import com.roche.lis.domainvalue.TestOperationVO;

@RunWith(MockitoJUnitRunner.class)
public class TestOperationServiceImplTest {

	@Mock
	private TestOperationCalculator testOperationCalculator;

	@Test
	public void executeTestOperation() {
		final Biochemistry testType = new Biochemistry(SubstanceTypeVO.GLUCOSE);
		testType.setTestOperation(TestOperationVO.TEST_OPERATION_1);
		final TestType spyTestType = Mockito.spy(testType);
		final TestOperationService testOperationService = new TestOperationServiceImpl();
		testOperationService.execute(spyTestType, testOperationCalculator);
		Mockito.verify(testOperationCalculator).calculate(spyTestType);
	}

}
