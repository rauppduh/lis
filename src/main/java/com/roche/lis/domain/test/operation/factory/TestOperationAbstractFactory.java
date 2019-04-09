package com.roche.lis.domain.test.operation.factory;

public class TestOperationAbstractFactory {

	public static AbstractFactory getTestOperationAbstractFactory(final String typeOperation) {
		if ("ONE".equalsIgnoreCase(typeOperation)) {
			return new TestOperationOneFactory();
		} else if ("TWO".equalsIgnoreCase(typeOperation)) {
			return new TestOperationTwoFactory();
		}
		throw new IllegalArgumentException(String.format("Type of operation %s is not supported", typeOperation));
	}

}
