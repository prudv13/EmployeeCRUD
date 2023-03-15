package com.JdbcMssql.EmployeeCRUD.ResultSetExtractor;

import com.JdbcMssql.EmployeeCRUD.DataModel.Employee;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeResultSetExtractor implements ResultSetExtractor<Employee> {

    @Override
    public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
        if(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            return new Employee(id, name, email);
        }
        else{
            return null;
        }
    }
}
