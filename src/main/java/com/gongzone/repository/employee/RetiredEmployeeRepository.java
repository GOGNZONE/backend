package com.gongzone.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gongzone.entity.employee.RetiredEmployee;

@Repository
public interface RetiredEmployeeRepository extends JpaRepository<RetiredEmployee, Long> {


}
