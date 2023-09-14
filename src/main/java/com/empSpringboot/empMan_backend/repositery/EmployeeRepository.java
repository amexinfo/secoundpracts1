package com.empSpringboot.empMan_backend.repositery;

import com.empSpringboot.empMan_backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
