package com.empSpringboot.empMan_backend.mapper;

import com.empSpringboot.empMan_backend.dto.DepartmentDto;
import com.empSpringboot.empMan_backend.entity.Department;

public class DepartmentMapper {
    public static DepartmentDto  changetoDepartmentDto(Department department) {
        return  new DepartmentDto( department.getDepartmentId(),
                                   department.getDepartmentName(),
                                   department.getDepartmentDesc());
    }
    public static Department chanetoDepartment(DepartmentDto departmentDto){
        return  new Department( departmentDto.getDepartmentId(),
                                departmentDto.getDepartmentName(),
                                departmentDto.getDepartmentDesc());
    }
}
