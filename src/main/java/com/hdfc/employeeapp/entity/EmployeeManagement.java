package com.hdfc.employeeapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import lombok.Data;

@Entity(name = "Employee")
@Data
public class EmployeeManagement {
    @Id
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "employee_name")
    @NotNull(message = "EmployeeName must not be blank")
    private String employeeName;

    @Column(name = "date_of_birth")
    @NotNull(message = "DateOfBirth must not be null")
    @Past(message = "DateOfBirth must be in the past")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

}
