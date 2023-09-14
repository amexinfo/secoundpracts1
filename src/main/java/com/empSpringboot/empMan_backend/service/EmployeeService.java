package com.empSpringboot.empMan_backend.service;

import com.empSpringboot.empMan_backend.dto.EmployeeDto;
import com.empSpringboot.empMan_backend.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto creatEmployeeDto(EmployeeDto employeeDto);
    EmployeeDto getEmployeeBy(Long employeeId);
    public List<EmployeeDto> getAllEmployees();
    public EmployeeDto updateEmployee(Long employeeId,EmployeeDto employeeDto);
    public void deleteEmployee(Long employeeId);
}
