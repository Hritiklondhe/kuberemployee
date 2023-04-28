package com.hdfc.employeeapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.employeeapp.exception.EmployeeNotFoundException;
import com.hdfc.employeeapp.service.IEmployeeService;
import com.hdfc.employeeapp.vo.EmployeeVO;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

    @Autowired
    private IEmployeeService employeeService;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);

    @GetMapping("/getById/{employeeId}")
    public EmployeeVO getEmployeeByEmployeeId(@PathVariable long employeeId) throws EmployeeNotFoundException {
        logger.info("Getting EmployeeId " + employeeId);
        return employeeService.getEmployeeById(employeeId);
    }
}