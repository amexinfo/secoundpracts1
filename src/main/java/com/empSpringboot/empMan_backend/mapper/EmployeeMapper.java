package com.empSpringboot.empMan_backend.mapper;

import com.empSpringboot.empMan_backend.dto.EmployeeDto;
import com.empSpringboot.empMan_backend.entity.Employee;

public class EmployeeMapper {
    public  static EmployeeDto changeMappEmployeeDto(Employee employee){
        return  new EmployeeDto(employee.getId(),
                                 employee.getFirstName(),
                                employee.getLastName(),
                                 employee.getEmail());
    }
    public static Employee ChangetoMappEmployee(EmployeeDto employeeDto){
        return new Employee(employeeDto.getId(),
                             employeeDto.getFirstName(),
                            employeeDto.getLastName(),
                            employeeDto.getEmail());
    }
}
