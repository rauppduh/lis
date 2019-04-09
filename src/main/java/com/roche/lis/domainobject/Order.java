package com.roche.lis.domainobject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {

	private Long id;
	private Clinician clinician;
	private Patient patient;
	private final List<TestType> testTypes = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Clinician getClinician() {
		return clinician;
	}

	public void setClinician(final Clinician clinician) {
		this.clinician = clinician;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(final Patient patient) {
		this.patient = patient;
	}

	public List<TestType> getTestTypes() {
		return Collections.unmodifiableList(testTypes);
	}

	public void addTestType(final TestType testTypes) {
		this.testTypes.add(testTypes);
	}

	public void removeTestType(final TestType testTypes) {
		this.testTypes.remove(testTypes);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Order other = (Order) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}
