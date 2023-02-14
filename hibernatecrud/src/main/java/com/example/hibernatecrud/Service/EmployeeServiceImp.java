package com.example.hibernatecrud.Service;
import com.example.hibernatecrud.DaO.EmployeeDao;
import com.example.hibernatecrud.Model.Employee;
import com.example.hibernatecrud.Model.EmployeeDepartment;
import com.example.hibernatecrud.Model.EmployeeProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImp implements EmployeeService{
    @Autowired
    EmployeeDao employeeDao;


    @Transactional
    @Override
    public List<Employee> get() {

        return employeeDao.get();
    }

    @Transactional
    @Override
    public EmployeeDepartment save(EmployeeDepartment employeeDepartmentobj)
    {
        employeeDao.save(employeeDepartmentobj);
        return employeeDepartmentobj;
    }
    @Transactional
    @Override
    public EmployeeDepartment getEmployeeDepartment(Integer id)
    {
        return employeeDao.getEmployeeDepartment(id);
    }
    @Transactional
    @Override
    public EmployeeProfile getEmpProfile(Integer id){
        return employeeDao.getEmpProfile(id);
    }
    @Transactional
    @Override
    public Employee get(int id) {

       return employeeDao.get(id);

    }
    @Transactional
    @Override
    public Employee save(Employee employee) {

        employeeDao.save(employee);
        return employee;
    }
    @Transactional
    @Override
    public EmployeeProfile save(EmployeeProfile empobj)
    {
        employeeDao.save(empobj);
        return empobj;
    }
    @Transactional
    @Override
    public void delete(int id) {
        employeeDao.delete(id);

    }
}
