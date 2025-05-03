package com.example.employee.repository;

import com.example.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByNameContainingIgnoreCaseOrDepartmentContainingIgnoreCase(String name, String department);
    List<Employee> findByDepartmentContainingIgnoreCase(String department);
    long countByDepartmentContainingIgnoreCase(String department);
    List<Employee> findBySalaryGreaterThanEqual(double minSalary);

    @Query("SELECT e FROM Employee e WHERE MONTH(e.birthday) = :month AND DAY(e.birthday) = :day")
    List<Employee> findEmployeesWithBirthdayOn(@Param("month") int month, @Param("day") int day);
}
