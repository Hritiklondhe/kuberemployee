package com.hdfc.employeeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdfc.employeeapp.entity.EmployeeManagement;

public interface EmployeeRepository extends JpaRepository<EmployeeManagement, Long> {

}
