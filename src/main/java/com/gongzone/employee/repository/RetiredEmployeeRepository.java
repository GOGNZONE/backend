package com.gongzone.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gongzone.employee.entity.Employee;
import com.gongzone.employee.entity.RetiredEmployee;

@Repository
public interface RetiredEmployeeRepository extends JpaRepository<RetiredEmployee, Long> {


}
