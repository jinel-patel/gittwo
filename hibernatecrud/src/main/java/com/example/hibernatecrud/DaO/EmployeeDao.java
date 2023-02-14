package com.example.hibernatecrud.DaO;

import com.example.hibernatecrud.Exception.NameNotEmpty;
import com.example.hibernatecrud.Model.Employee;
import com.example.hibernatecrud.Model.EmployeeDepartment;
import com.example.hibernatecrud.Model.EmployeeProfile;

import java.util.List;

public interface EmployeeDao {

    List<Employee> get();
    Employee get(int id);
    Employee save(Employee employee) throws NameNotEmpty;

    EmployeeProfile save(EmployeeProfile empobj);
    EmployeeDepartment save(EmployeeDepartment employeeDepartmentobj);

    EmployeeDepartment getEmployeeDepartment(Integer id);
    EmployeeProfile getEmpProfile(Integer id);

    void delete(int id);
}
