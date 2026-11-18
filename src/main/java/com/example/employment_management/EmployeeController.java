package com.example.employment_management;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    List<Employee> employees = new ArrayList<>();


    // PART B: ADD EMPLOYEE

    @PostMapping("/employees")
    public String addEmployee(@RequestBody Employee employee) {

        employees.add(employee);

        return "Employee added successfully!";
    }


    // PART C (1): GET ALL EMPLOYEES

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {

        return employees;
    }


    // PART C (2): GET EMPLOYEE BY ID

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {

        for (Employee e : employees) {

            if (e.getId() == id) {

                return e;
            }

        }

        return null;
    }
    // Part D :UPDATION
    @PutMapping("/employees/{id}")
    public String updateEmployee(@PathVariable int id,
                                 @RequestBody Employee updatedEmployee) {

        for (Employee e : employees) {

            if (e.getId() == id) {

                e.setName(updatedEmployee.getName());
                e.setDepartment(updatedEmployee.getDepartment());
                e.setSalary(updatedEmployee.getSalary());

                return "Employee updated successfully!";
            }
        }

        return "Employee not found!";
    }
    // PART E: DELETE EMPLOYEE

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {

        for (Employee e : employees) {

            if (e.getId() == id) {

                employees.remove(e);

                return "Employee deleted successfully!";
            }
        }

        return "Employee not found!";
    }
}