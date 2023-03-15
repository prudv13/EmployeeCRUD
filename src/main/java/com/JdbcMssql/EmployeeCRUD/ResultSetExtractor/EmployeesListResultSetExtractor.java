package com.JdbcMssql.EmployeeCRUD.ResultSetExtractor;

import com.JdbcMssql.EmployeeCRUD.DataModel.Employee;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeesListResultSetExtractor implements ResultSetExtractor<List<Employee>> {


    @Override
    public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<Employee> employees = new ArrayList<>();
        while(rs.next()){
            Employee employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setEmail(rs.getString("email"));
            employees.add(employee);
        }
        return employees;
    }
}
