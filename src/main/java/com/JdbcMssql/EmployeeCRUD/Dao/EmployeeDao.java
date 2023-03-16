package com.JdbcMssql.EmployeeCRUD.Dao;

import com.JdbcMssql.EmployeeCRUD.DataModel.Employee;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(int id);
    public Employee insertNewEmployee(Employee employee);
    public Employee updateEmployeeById(int id, Employee employee);
    public Employee updateEmployeeNameField(int id, Employee employee);
    public void deleteEmployee(int id);

}
