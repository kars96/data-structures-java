package com.hash;

import java.lang.instrument.Instrumentation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class HashSetJavaCollection {
	public static void main(String args[]) throws IllegalAccessException, IllegalArgumentException, Exception {
		Set<Employee> s = new HashSet<>();
		Employee e = new Employee("kar", "ham");
		s.add(e);
		e.ID = "k";
		e.name = "h";
		System.out.println("Insert complete");
		System.out.println(s.contains(new Employee("k", "h")));
	}
}
