package com.example.hibernatecrud.DTO;

public class EmployeeDepartmentDto {
    public EmployeeDepartmentDto() {
    }

    private String depName;

    public EmployeeDepartmentDto(String depName) {
        this.depName = depName;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }


}
