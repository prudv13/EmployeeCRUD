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

    public Employee insertNewEmployee(Employee employee) {
        return employeeDao.insertNewEmployee(employee);
    }

    public Employee updateEmployeeById(int id, Employee employee){
        return employeeDao.updateEmployeeById(id, employee);
    }

    public Employee updateEmployeeNameField(int id, Employee employee){
        return employeeDao.updateEmployeeNameField(id, employee);
    }

    public void deleteEmployee(int id){
        employeeDao.deleteEmployee(id);
    }
}
