package com.java.employees.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.java.employees.model.Employee;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace =AutoConfigureTestDatabase.Replace.NONE)
public class DaoTest {
	@Autowired
	EmployeeRepository employeeRepository;
	@Test
	public void testCreate() {
		Employee employee= new Employee("admin","Manager");
		employeeRepository.save(employee);
		Iterable<Employee> itr= employeeRepository.findAll();
		Assertions.assertThat(itr).extracting(e->e.getFirstName()).containsOnly("admin");
		employeeRepository.deleteAll();
		Assertions.assertThat(employeeRepository.findAll()).isEmpty();
		
		
	}

}
