package com.java.employees.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.java.employees.dao.EmployeeRepository;
import com.java.employees.model.Employee;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
	@InjectMocks
	EmployeeService service;
	@Mock
	EmployeeRepository repository;
	
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	@Test
	public void testFindEmp() {
		List<Employee> list= new ArrayList<Employee>();
		list.add(new Employee("alex", "alex"));
		list.add(new Employee("sam", "sam"));
		list.add(new Employee("steve", "steve"));
		Mockito.when(repository.findAll()).thenReturn(list);
		List<Employee>emplList= service.findAll();
		assertEquals(3, emplList.size());
		
	}
	public void testCreate() {
		Employee emp= new Employee("adam", "adam");
		service.save(emp);
		Mockito.verify(repository,Mockito.times(1)).save(emp);
	}

}
