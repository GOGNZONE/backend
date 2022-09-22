package com.gongzone.repository.employee;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gongzone.entity.employee.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Optional<Employee> findByEmployeeEmail(String employeeEmail);
	
	boolean existsByEmployeeEmail(String employeeEmail);
	
	boolean existsByEmployeeId(Long employeeId);
}
