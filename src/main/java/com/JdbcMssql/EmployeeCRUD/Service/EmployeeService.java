package com.JdbcMssql.EmployeeCRUD.Service;

import com.JdbcMssql.EmployeeCRUD.Dao.EmployeeDaoImpl;
import com.JdbcMssql.EmployeeCRUD.DataModel.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDaoImpl employeeDao;

    public List<Employee> getAllEmployees(){
        return employeeDao.getAllEmployees();
    }

    public Employee getEmployeeById(int id){
        return employeeDao.getEmployeeById(id);
    }

    public Void insertNewEmployee(Employee employee) {
        employeeDao.insertNewEmployee(employee);
        return null;
    }

    public Void updateEmployeeById(int id, Employee employee){
        employeeDao.updateEmployeeById(id, employee);
        return null;
    }

    public Employee updateEmployeeNameField(int id, Employee employee){
        return employeeDao.updateEmployeeNameField(id, employee);
    }

    public Void deleteEmployee(int id){
        employeeDao.deleteEmployee(id);
        return null;
    }
}