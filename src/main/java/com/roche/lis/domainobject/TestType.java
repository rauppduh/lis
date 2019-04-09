package com.roche.lis.domainobject;

import com.roche.lis.domainvalue.SubstanceTypeVO;
import com.roche.lis.domainvalue.TestOperationVO;

public class TestType {

	private Long id;
	private SubstanceTypeVO substanceTypeVO;
	private TestOperationVO testOperation;
	private String commonFakeProperty1;
	private String commonFakeProperty2;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getCommonFakeProperty1() {
		return commonFakeProperty1;
	}

	public void setCommonFakeProperty1(final String commonFakeProperty1) {
		this.commonFakeProperty1 = commonFakeProperty1;
	}

	public String getCommonFakeProperty2() {
		return commonFakeProperty2;
	}

	public void setCommonFakeProperty2(final String commonFakeProperty2) {
		this.commonFakeProperty2 = commonFakeProperty2;
	}

	public SubstanceTypeVO getSubstanceTypeVO() {
		return substanceTypeVO;
	}

	public void setSubstanceTypeVO(final SubstanceTypeVO substanceTypeVO) {
		this.substanceTypeVO = substanceTypeVO;
	}

	public TestOperationVO getTestOperation() {
		return testOperation;
	}

	public void setTestOperation(final TestOperationVO testOperation) {
		this.testOperation = testOperation;
	}

}
