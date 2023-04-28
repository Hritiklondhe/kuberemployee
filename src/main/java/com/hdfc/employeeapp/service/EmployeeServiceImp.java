package com.hdfc.employeeapp.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.employeeapp.entity.EmployeeManagement;
import com.hdfc.employeeapp.exception.EmployeeNotFoundException;
import com.hdfc.employeeapp.repository.EmployeeRepository;
import com.hdfc.employeeapp.vo.EmployeeVO;

@Service
public class EmployeeServiceImp implements IEmployeeService {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(EmployeeServiceImp.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeVO getEmployeeById(Long employeeId) throws EmployeeNotFoundException {
        logger.info("Getting employee by id: {}", employeeId);
        EmployeeManagement employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with Id: " + employeeId));
        EmployeeVO employeeVo = new EmployeeVO();
        employeeVo.setEmployeeId(employeeId);
        employeeVo.setEmployeeName(employee.getEmployeeName());
        String dob = employee.getDateOfBirth().toString();
        try {
            employeeVo.setDateOfBirth(EmployeeVO.encryptCode(dob));
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("Employee details - Employee Id: {}, Employee Name: {}, Encrypted Date of Birth: {}", employeeId,
                employee.getEmployeeName(), employeeVo.getDateOfBirth());
        return employeeVo;
    }

}
