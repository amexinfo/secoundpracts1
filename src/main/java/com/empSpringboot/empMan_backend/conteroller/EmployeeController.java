package com.empSpringboot.empMan_backend.conteroller;

import com.empSpringboot.empMan_backend.dto.EmployeeDto;
import com.empSpringboot.empMan_backend.entity.Employee;
import com.empSpringboot.empMan_backend.mapper.EmployeeMapper;
import com.empSpringboot.empMan_backend.repositery.EmployeeRepository;
import com.empSpringboot.empMan_backend.service.EmployeeService;
import com.empSpringboot.empMan_backend.service.EmployeeServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    private EmployeeService employeeService;
  @PostMapping
    public ResponseEntity<EmployeeDto>createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto saveEmployeeDto=employeeService.creatEmployeeDto(employeeDto);

        return  new ResponseEntity<>(saveEmployeeDto,HttpStatus.CREATED);

    }
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDto employeeDto = employeeService.getEmployeeBy(employeeId);
        return ResponseEntity.ok(employeeDto);
    }
    @GetMapping

    public ResponseEntity<List<EmployeeDto>>getAllEmployees(){
      List<EmployeeDto>employees=employeeService.getAllEmployees();
      return  ResponseEntity.ok(employees);
    }
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto employeeDto){
  EmployeeDto employeeDto1=employeeService.updateEmployee(employeeId,employeeDto);
  return ResponseEntity.ok(employeeDto1);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteEmployee(@PathVariable("id") Long employeeId){
      employeeService.deleteEmployee(employeeId);
      return ResponseEntity.ok("delete employee success");
    }

}
