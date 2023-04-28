package com.hdfc.employeeapp.service;

import com.hdfc.employeeapp.exception.EmployeeNotFoundException;
import com.hdfc.employeeapp.vo.EmployeeVO;

public interface IEmployeeService {

    public EmployeeVO getEmployeeById(Long employeeId) throws EmployeeNotFoundException;

}
