package com.example.hibernatecrud.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="emp")
public class Employee {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Integer id;
    @NotEmpty
    @Size(min=2 , message = "firstname should have minimum two letters")
    @Column(name="first_name", columnDefinition="VARCHAR(128)")
    private String firstName;
    @NotEmpty
    @Size(min=2 , message = "firstname should have minimum two letters")
    @Column(name="last_name",columnDefinition="VARCHAR(128)")
    private String lastName;
    @NotEmpty
    @Email
    @Column(name="email_id",columnDefinition="VARCHAR(128)")
    private String emailId;

    @OneToOne(fetch = FetchType.LAZY)
  //  @JoinColumn(name="emp_pro_id")
    private com.example.hibernatecrud.Model.EmployeeProfile EmployeeProfile;

    public com.example.hibernatecrud.Model.EmployeeProfile getEmployeeProfile() {
        return EmployeeProfile;
    }

    public void setEmployeeProfile(com.example.hibernatecrud.Model.EmployeeProfile employeeProfile) {
        EmployeeProfile = employeeProfile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Employee(Integer id, String firstName, String lastName, String emailId, com.example.hibernatecrud.Model.EmployeeProfile EmployeeProfile) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.EmployeeProfile=EmployeeProfile;

    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", EmployeeProfile='" + EmployeeProfile + '\'' +

                '}';
    }

    public Employee()
    {

    }


}
