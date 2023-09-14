package com.empSpringboot.empMan_backend.service;

import com.empSpringboot.empMan_backend.dto.EmployeeDto;
import com.empSpringboot.empMan_backend.entity.Employee;
import com.empSpringboot.empMan_backend.exception.ResourceException;
import com.empSpringboot.empMan_backend.mapper.EmployeeMapper;
import com.empSpringboot.empMan_backend.repositery.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class EmployeeServiceImp implements EmployeeService {
    private EmployeeRepository employeeRepository;


    @Override
    public EmployeeDto creatEmployeeDto(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.ChangetoMappEmployee(employeeDto);
        Employee employeeSave = employeeRepository.save(employee);
        return EmployeeMapper.changeMappEmployeeDto(employeeSave);


    }

    @Override
    public EmployeeDto getEmployeeBy(Long employeeId) {
        Employee emp = employeeRepository.findById(employeeId).orElseThrow(() ->
                new ResourceException("employye not found" + employeeId));
        return EmployeeMapper.changeMappEmployeeDto(emp);


    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> list = employeeRepository.findAll();
        return list.stream().map(employee -> EmployeeMapper.changeMappEmployeeDto(employee)).
                collect(Collectors.toList());


    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {
       Employee employee= employeeRepository.findById(employeeId).orElseThrow(()->
                new ResourceException("NOT FOUND THE EMPLOYEE"));
           employee.setFirstName(employeeDto.getFirstName());
           employee.setLastName(employeeDto.getLastName());
           employee.setEmail(employeeDto.getEmail());
           employeeRepository.save(employee);
        return EmployeeMapper.changeMappEmployeeDto(employee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee emp = employeeRepository.findById(employeeId).orElseThrow(() ->
                new ResourceException("employye not found" + employeeId));
         employeeRepository.deleteById(employeeId);

    }
}
