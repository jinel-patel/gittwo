package com.example.hibernatecrud.Service;

import com.example.hibernatecrud.Exception.NameNotEmpty;
import com.example.hibernatecrud.Model.Employee;
import com.example.hibernatecrud.Model.EmployeeDepartment;
import com.example.hibernatecrud.Model.EmployeeProfile;

import java.util.List;

public interface EmployeeService {

    List<Employee> get();
    Employee get(int id);
    EmployeeProfile getEmpProfile(Integer id);
    Employee save(Employee employee) throws NameNotEmpty;

    EmployeeProfile save(EmployeeProfile empobj);

    EmployeeDepartment save(EmployeeDepartment employeeDepartmentobj);

    EmployeeDepartment getEmployeeDepartment(Integer id);

    void delete(int id);
}
