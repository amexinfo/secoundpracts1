package com.empSpringboot.empMan_backend.service;

import com.empSpringboot.empMan_backend.dto.DepartmentDto;
import com.empSpringboot.empMan_backend.entity.Department;

import java.util.List;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);
    DepartmentDto  getDepartmentById(Long Id);
    List<DepartmentDto> getAllDepartment();
    DepartmentDto updateDepartment(Long id ,DepartmentDto  departmentDto );
     void deleteDepartmentById(Long id);
}
