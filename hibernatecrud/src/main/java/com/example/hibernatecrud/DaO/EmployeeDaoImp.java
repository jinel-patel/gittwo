package com.example.hibernatecrud.DaO;
import com.example.hibernatecrud.Exception.EmployeeNotFoundException;
import com.example.hibernatecrud.Exception.NameNotEmpty;
import com.example.hibernatecrud.Model.EmployeeDepartment;
import com.example.hibernatecrud.Model.EmployeeProfile;
import org.hibernate.query.Query;
import com.example.hibernatecrud.Model.Employee;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class EmployeeDaoImp implements EmployeeDao{
    @Autowired
  private EntityManager entityManager;

    @Override
    public List<Employee> get() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
        List<Employee> list = query.getResultList();

        return list;
    }

    @Override
    public Employee get(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Employee employeeObj = currentSession.get(Employee.class,id);
        if(employeeObj==null)
        {
            throw new EmployeeNotFoundException("Employee not present in database");
        }
        try
        {
            return employeeObj;
        }

        catch(Exception e)
        {
            throw new EmployeeNotFoundException("Somethogn went wrong" + e.getMessage());
        }



    }
    @Override

    public EmployeeDepartment save(EmployeeDepartment employeeDepartmentobj)
    {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(employeeDepartmentobj);
        return employeeDepartmentobj;
    }
    @Override
    public EmployeeProfile getEmpProfile(Integer id){
        Session currentSession = entityManager.unwrap(Session.class);
        EmployeeProfile empProfileObj=currentSession.get(EmployeeProfile.class,id);
        return empProfileObj;
    }

    @Override
    public EmployeeDepartment getEmployeeDepartment(Integer id)
    {
        Session currentSession = entityManager.unwrap(Session.class);
        EmployeeDepartment employeeDepartmentobj =currentSession.get(EmployeeDepartment.class,id);
        return employeeDepartmentobj;
    }
    @Override
    public EmployeeProfile save(EmployeeProfile empobj)
    {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(empobj);
        return empobj;
    }

    @Override
    public Employee save(Employee employee) throws NameNotEmpty {
       Session currentSession = entityManager.unwrap(Session.class);
        if(employee.getFirstName().isEmpty() || employee.getFirstName().length() == 1) {
           throw new NameNotEmpty("Please send proper name, It blank");
        }
    //   try {
        currentSession.saveOrUpdate(employee);
           return employee;
    //   }

//       catch (Exception e) {
//           throw new NameNotEmpty("Something went wrong in Service layer while saving the employee" + e.getMessage());
//       }



    }

    @Override
    public void delete(int id) {

        Session currentSession = entityManager.unwrap(Session.class);
      Employee employeeObj=  currentSession.get(Employee.class,id);
      currentSession.delete(employeeObj);

    }

}
