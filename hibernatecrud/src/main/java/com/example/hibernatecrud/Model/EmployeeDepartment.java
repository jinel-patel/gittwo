package com.example.hibernatecrud.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="department")
public class EmployeeDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="department_name")
    private String depName;

    public EmployeeDepartment() {
    }

    public EmployeeDepartment(Integer id, String depName) {
        this.id = id;
        this.depName = depName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }
    @OneToMany(cascade = CascadeType.ALL)
    List< Employee > employess = new ArrayList<>();

    public List<Employee> getEmployess() {
        return employess;
    }

    public void setEmployess(List<Employee> employess) {
        this.employess = employess;
    }

    @Override
    public String toString() {
        return "EmployeeDepartment{" +
                "id=" + id +
                ", depName='" + depName + '\'' +
                ", employess=" + employess +
                '}';
    }
}
