package com.springbootprojects.employeesystemapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.springbootprojects.employeesystemapi.models.Employee;
import com.springbootprojects.employeesystemapi.services.EmployeeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/api/v1/")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "/employees")
    public Employee createEmployee(@RequestBody Employee employee){

        return employeeService.createEmployee(employee);
    }

    @GetMapping(value = "/employees")
    public List<Employee> getAllEmployees(){

       return  employeeService.getAllEmployees();
    }

    @DeleteMapping(value = "/employees/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
        boolean deleted = false;
        deleted = employeeService.deleteEmployee(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",deleted);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = null;
        employee = employeeService.getAllEmployeeById(id);
        return ResponseEntity.ok(employee);

    }

    @PutMapping(value = "/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        employee = employeeService.updateEmployee(id,employee);
        return ResponseEntity.ok(employee);

    }


}
