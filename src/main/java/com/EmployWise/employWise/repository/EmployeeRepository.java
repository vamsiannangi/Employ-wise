package com.EmployWise.employWise.repository;

import com.EmployWise.employWise.entities.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {


}