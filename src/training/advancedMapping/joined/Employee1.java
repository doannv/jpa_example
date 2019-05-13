/*
	* (C) Copyright 2019 
	*
	* @Author Doan Nguyen
	* @Date May 13, 2019
*/
package training.advancedMapping.joined;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "employee_details")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee1 {

	@Id
	private int e_id;
	private String e_name;

	public Employee1() {
		super();
	}

	public Employee1(int e_id, String e_name) {
		super();
		this.e_id = e_id;
		this.e_name = e_name;
	}

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

}
