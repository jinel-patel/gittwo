package com.example.hibernatecrud.Controller;

import com.example.hibernatecrud.DTO.EmployyeDto;
import com.example.hibernatecrud.Model.Employee;
import com.example.hibernatecrud.Model.EmployeeDepartment;
import com.example.hibernatecrud.Model.EmployeeProfile;
import com.example.hibernatecrud.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emp_name")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/employee")
    public List<Employee> get()
    {
       return employeeService.get();
    }
    @PostMapping("/employee/dep")
    public EmployeeDepartment save(@RequestBody  EmployeeDepartment employeeDepartmentobj)
    {
        System.out.println(employeeDepartmentobj.toString());
        employeeService.save(employeeDepartmentobj);
        return employeeDepartmentobj;
    }




//    public ResponseEntity<?> save(@RequestBody  EmployyeDto employeeObj) //throws NameNotEmpty
//    {
//        // try {
//
//        System.out.println(employeeObj.toString());
//        EmployeeProfile ep= employeeService.getEmpProfile(employeeObj.getEmployeeProfile());
//
//        Employee e=new Employee();
//        e.setFirstName(employeeObj.getFirstName());
//        e.setLastName(employeeObj.getLastName());
//        e.setEmailId(employeeObj.getEmailId());
//        e.setEmployeeProfile(ep);
//
//        Employee e1 = employeeService.save(e);
//
//        return new ResponseEntity<Employee>(e1, HttpStatus.CREATED);
//
//    }


    @PostMapping("/employee")


   public ResponseEntity<?> save(@RequestBody  EmployyeDto employeeObj) //throws NameNotEmpty
    {
     // try {

           System.out.println(employeeObj.toString());
             EmployeeProfile ep= employeeService.getEmpProfile(employeeObj.getEmployeeProfile());
            EmployeeDepartment ed =employeeService.getEmployeeDepartment(employeeObj.getEmployeeDepartment());
            System.out.println(ed);
        Employee e=new Employee();
        EmployeeDepartment ed1 = new EmployeeDepartment();
        e.setFirstName(employeeObj.getFirstName());
        e.setLastName(employeeObj.getLastName());
        e.setEmailId(employeeObj.getEmailId());
        e.setEmployeeProfile(ep);
       // ed1.setEmployess(ed);

          Employee e1 = employeeService.save(e);

          return new ResponseEntity<Employee>(e1, HttpStatus.CREATED);

          //}
//       catch(Exception e)
//       {
//           //System.out.println(e.getMessage());
//          //throw new ErrorException("ff","ffh");
//          // e.printStackTrace();
////           return ResponseEntity.ok(e1);
//          //NameNotEmpty ee=new NameNotEmpty(e.getMessage(),e.getMessage());
   //       return new ResponseEntity<String>("Name should not be empty",HttpStatus.BAD_REQUEST);
//       }
      }
      //  return ResponseEntity.ok(e1);}
     @PostMapping("/employee/emp")
    public EmployeeProfile save(@RequestBody EmployeeProfile empobj)
    {
        employeeService.save(empobj);
        return empobj;
    }
    @GetMapping("/employee/{id}")
    public Employee get(@PathVariable int id)
    {
       return employeeService.get(id);
    }

    @DeleteMapping("employee/{id}")
    public String delete(@PathVariable int id)
    {
         employeeService.delete(id);
         return "Employee is deleted wit hid " +id;
    }
    @PutMapping("/employee")
    public Employee update(@RequestBody @Valid Employee employeeObj)
    {
        employeeService.save(employeeObj);
        return employeeObj;
    }

}
