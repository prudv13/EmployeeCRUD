package com.JdbcMssql.EmployeeCRUD.Dao;

import com.JdbcMssql.EmployeeCRUD.DataModel.Employee;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(int id);
    public Void insertNewEmployee(Employee employee);
    public Void updateEmployeeById(int id, Employee employee);
    public Employee updateEmployeeNameField(int id, Employee employee);
    public Void deleteEmployee(int id);

}
