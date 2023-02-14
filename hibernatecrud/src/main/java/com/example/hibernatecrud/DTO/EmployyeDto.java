package com.example.hibernatecrud.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class EmployyeDto {
    private String firstName;
    private String lastName;
    private String emailId;
    private Integer employeeProfile;
    private Integer employeeDepartment;

    public Integer getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(Integer employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }


    public EmployyeDto() {
    }

    public EmployyeDto(String firstName, String lastName, String emailId, Integer employeeProfile,Integer employeeDepartment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.employeeProfile = employeeProfile;
        this.employeeDepartment=employeeDepartment;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Integer getEmployeeProfile() {
        return employeeProfile;
    }

    public void setEmployeeProfile(Integer employeeProfile) {
        this.employeeProfile = employeeProfile;
    }

    @Override
    public String toString() {
        return "EmployyeDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", employeeProfile='" + employeeProfile + '\'' +
                ", employeeDepartment='" + employeeDepartment + '\'' +
                '}';
    }
}
