package com.example.hibernatecrud.Model;

import jakarta.persistence.*;

@Entity
@Table(name="employee_profile")
public class EmployeeProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="address")
    private String address;



//    @OneToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "EmployeeProfile")
    //  private Employee employee;

    public EmployeeProfile(Integer id, String phoneNumber, String address) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public EmployeeProfile()
    {

    }


    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
