/*
	* (C) Copyright 2019 
	*
	* @Author Doan Nguyen
	* @Date May 13, 2019
*/
package training.advancedMapping.singleTable;

import javax.persistence.Entity;

@Entity
public class RetiredEmployee extends Employee {

	private int e_pension;

	public RetiredEmployee(int e_id, String e_name, int e_pension) {
		super(e_id, e_name);
		this.e_pension = e_pension;
	}

	public RetiredEmployee() {
		super();

	}

	public int getE_pension() {
		return e_pension;
	}

	public void setE_pension(int e_pension) {
		this.e_pension = e_pension;
	}

}
