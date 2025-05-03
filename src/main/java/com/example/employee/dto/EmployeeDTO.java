package com.example.employee.dto;

import com.example.employee.model.Employee;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotBlank(message = "Position cannot be blank")
    private String position;

    @Positive(message = "Salary must be positive")
    private double salary;

    @NotBlank(message = "Department cannot be blank")
    private String department;

    @NotNull(message = "Birthday cannot be null")
    private LocalDate birthday;

    public EmployeeDTO() {}

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.email = employee.getEmail();
        this.position = employee.getPosition();
        this.salary = employee.getSalary();
        this.department = employee.getDepartment();
        this.birthday = employee.getBirthday();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
