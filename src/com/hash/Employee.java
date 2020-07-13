package com.hash;

import java.util.Objects;

public class Employee {
	public String ID;

	public String name;
	public int age;
	public String gender;
	
	public Employee(String iD, String name) {
		super();
		ID = iD;
		this.name = name;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("eqs called for " + this.ID);
		Employee e = (Employee)obj;
		return e.ID == this.ID && e.name == this.name;
	}
	
	@Override
	public int hashCode() {
		System.out.println("hash called for " + this.ID);
		return this.ID.hashCode() + this.name.hashCode();
	}
}
