package com.hdfc.employeeapp.dto;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeManagementDTO {

    @Id
    private Long employeeId;
    private String employeeName;
    private String dateOfBirth;

}
