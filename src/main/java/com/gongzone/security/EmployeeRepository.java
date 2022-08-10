package com.gongzone.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gongzone.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@EntityGraph(attributePaths = {"roleSet"}, type = EntityGraph.EntityGraphType.LOAD)
	@Query("SELECT e from employee e WHERE e.employee_email = :employeeEmail")
	Optional<Employee> findEmployeeByEmail(String employeeEmail);
	
}
