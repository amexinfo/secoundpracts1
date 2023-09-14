package com.empSpringboot.empMan_backend.conteroller;

import com.empSpringboot.empMan_backend.dto.DepartmentDto;
import com.empSpringboot.empMan_backend.entity.Department;
import com.empSpringboot.empMan_backend.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    @PostMapping
    public ResponseEntity<DepartmentDto>creatdepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto  department=departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto>getById(@PathVariable("id") Long id){
        DepartmentDto departmentDto=departmentService.getDepartmentById(id);
        return new ResponseEntity<>(departmentDto,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<DepartmentDto>>getAllDepartment(){
        List<DepartmentDto>dep=departmentService.getAllDepartment();
        return ResponseEntity.ok(dep);
    }
    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto>updateDepartment(@PathVariable("id") Long id,DepartmentDto departmentdto){
        DepartmentDto departmentDto=departmentService.updateDepartment(id,departmentdto);
        return  ResponseEntity.ok(departmentdto);

    }
    @DeleteMapping("{ID}")
    public ResponseEntity<String>deletDepartmintByID(@PathVariable("ID") Long ID){

        return  ResponseEntity.ok("DELETE SUCCESS");

    }
}

