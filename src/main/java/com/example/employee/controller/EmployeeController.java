package com.example.employee.controller;

import com.example.employee.dto.EmployeeDTO;
import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        try {
            Employee employee = new Employee();
            employee.setEmail(employeeDTO.getEmail());
            employee.setName(employeeDTO.getName());
            employee.setPosition(employeeDTO.getPosition());
            employee.setSalary(employeeDTO.getSalary());
            employee.setDepartment(employeeDTO.getDepartment());
            employee.setBirthday(employeeDTO.getBirthday());

           
            Employee savedEmployee = employeeService.saveEmployee(employee);

            
            EmployeeDTO savedEmployeeDTO = new EmployeeDTO();
            savedEmployeeDTO.setEmail(savedEmployee.getEmail());
            savedEmployeeDTO.setName(savedEmployee.getName());
            savedEmployeeDTO.setPosition(savedEmployee.getPosition());
            savedEmployeeDTO.setSalary(savedEmployee.getSalary());
            savedEmployeeDTO.setDepartment(savedEmployee.getDepartment());
            savedEmployeeDTO.setBirthday(savedEmployee.getBirthday());

            return new ResponseEntity<>(savedEmployeeDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "Employee deleted successfully!";
    }
}
