package com.EmployWise.employWise.services;


import com.EmployWise.employWise.entities.Employee;
import com.EmployWise.employWise.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(String id) {
        return employeeRepository.findById(id);
    }

    public void deleteEmployeeById(String id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(String id, Employee updatedEmployee) {
        if (employeeRepository.existsById(id)) {
            updatedEmployee.setId(id);
            return employeeRepository.save(updatedEmployee);
        }
        return null;
    }


    public Optional<Employee> getNthLevelManager(String employeeId, int level) {
        Optional<Employee> employeeOptional = getEmployeeById(employeeId);
        if (employeeOptional.isPresent()) {
            String managerId = employeeOptional.get().getReportsTo();

            if(managerId!=null) {
                for (int i = 1; i < level; i++) {
                    Optional<Employee> managerOptional = getEmployeeById(managerId);
                    if (managerOptional.isPresent()) {
                        managerId = managerOptional.get().getReportsTo();
                    } else {
                        break;
                    }
                }
            }

            return getEmployeeById(managerId);
        }

        return Optional.empty();
    }

    public List<Employee> getEmployeesWithPaginationAndSorting(int page, int size, String sortBy) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Employee> employeePage = employeeRepository.findAll(pageRequest);
        return employeePage.getContent();
    }

}
