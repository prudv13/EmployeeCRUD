package com.JdbcMssql.EmployeeCRUD.Controller;

import com.JdbcMssql.EmployeeCRUD.DataModel.Employee;
import com.JdbcMssql.EmployeeCRUD.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addemployee")
    public ResponseEntity<Employee> insertNewEmployee(@RequestBody Employee employee){
        try{
            Employee newEmployee = employeeService.insertNewEmployee(employee);
            return new ResponseEntity<Employee>(newEmployee, HttpStatus.CREATED);
        }
        catch(Exception exception){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        try{
            List<Employee> employees = employeeService.getAllEmployees();
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }
        catch(Exception exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id){
        try{
            Employee employee = employeeService.getEmployeeById(id);
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        }
        catch(Exception exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/employees/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable("id") int id, @RequestBody Employee employee){
        try{
            Employee updateEmployee = employeeService.updateEmployeeById(id, employee);
            return new ResponseEntity<Employee>(updateEmployee, HttpStatus.ACCEPTED);
        }
        catch(Exception exception){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping(value = "/employee/{id}")
    public ResponseEntity<Employee> updateEmployeeNameField(@PathVariable("id") int id, @RequestBody Employee employee){
        try{
            Employee updateEmployee = employeeService.updateEmployeeNameField(id, employee);
            return new ResponseEntity<Employee>(updateEmployee, HttpStatus.ACCEPTED);
        }
        catch(Exception exception){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id){
        Employee deletedEmployeeId = employeeService.getEmployeeById(id);
        if(id > 0 && deletedEmployeeId != null){
            try{
                employeeService.deleteEmployee(id);
            }
            catch(Exception e){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource found, but cannot be deleted");
            }
            return ResponseEntity.status(HttpStatus.OK).body("Deleted the Employee with provided ID");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Provided ID is invalid");
        }
    }
}
