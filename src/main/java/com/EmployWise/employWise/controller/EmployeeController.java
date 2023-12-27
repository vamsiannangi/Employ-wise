package com.EmployWise.employWise.controller;


import com.EmployWise.employWise.entities.Employee;
import com.EmployWise.employWise.repository.EmployeeRepository;
import com.EmployWise.employWise.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee employee) {
        Employee addedEmployee = employeeService.addEmployee(employee);
        return "Employee added successfully with ID: " + addedEmployee.getId();
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public java.util.Optional<Employee> getEmployeeById(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable String id) {
        employeeService.deleteEmployeeById(id);
        return "Employee deleted successfully";
    }

    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable String id, @RequestBody Employee updatedEmployee) {
        Employee updated = employeeService.updateEmployee(id, updatedEmployee);
        if (updated != null) {
            return "Employee updated successfully";
        } else {
            return "Employee with ID " + id + " not found";
        }
    }


    @PostMapping("/add-multiple")
    public String addMultipleEmployees(@RequestBody List<Employee> employees) {
        try {
            for (Employee employee : employees) {
                employeeRepository.save(employee);
            }
            return "Employees added successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to add employees. Error: " + e.getMessage();
        }
    }

    @GetMapping("/manager")
    public java.util.Optional<Employee> getNthLevelManager(
            @RequestParam String employeeId,
            @RequestParam int level
    ) {
        return employeeService.getNthLevelManager(employeeId, level);
    }

    @GetMapping("/paged")
    public List<Employee> getEmployeesWithPaginationAndSorting(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy
    ) {
        return employeeService.getEmployeesWithPaginationAndSorting(page, size, sortBy);
    }

}