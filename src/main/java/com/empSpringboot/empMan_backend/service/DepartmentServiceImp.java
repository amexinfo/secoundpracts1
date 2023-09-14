package com.empSpringboot.empMan_backend.service;

import com.empSpringboot.empMan_backend.dto.DepartmentDto;
import com.empSpringboot.empMan_backend.entity.Department;
import com.empSpringboot.empMan_backend.exception.ResourceException;
import com.empSpringboot.empMan_backend.mapper.DepartmentMapper;
import com.empSpringboot.empMan_backend.repositery.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class DepartmentServiceImp implements DepartmentService {
    @Autowired
    DepartmentRepository  departmentRepository;
    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department=DepartmentMapper.chanetoDepartment(departmentDto);
          departmentRepository.save(department);
          return DepartmentMapper.changetoDepartmentDto(department);
    }

    @Override
    public DepartmentDto getDepartmentById(Long Id) {
        Department department=departmentRepository.getReferenceById(Id);
        return DepartmentMapper.changetoDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartment() {
        List<Department>dep=departmentRepository.findAll();
        return dep.stream().map(department -> DepartmentMapper.changetoDepartmentDto(department)).collect(Collectors.toList());
    }


    @Override
    public DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto) {
        Department department=departmentRepository.findById(id).orElseThrow(()->new ResourceException("no  Department by this ID"));
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentDesc(departmentDto.getDepartmentDesc());
       Department department1= departmentRepository.save(department);
        return DepartmentMapper.changetoDepartmentDto(department1);
    }

    @Override
    public void deleteDepartmentById(Long id) {
        Department department=departmentRepository.findById(id).orElseThrow(()->new ResourceException("NO department ny this id"));
        departmentRepository.findById(id);

    }
}
