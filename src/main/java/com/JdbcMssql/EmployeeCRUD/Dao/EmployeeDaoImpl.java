package com.JdbcMssql.EmployeeCRUD.Dao;

import com.JdbcMssql.EmployeeCRUD.DataModel.Employee;
import com.JdbcMssql.EmployeeCRUD.Dto.EmployeeDto;
import com.JdbcMssql.EmployeeCRUD.ResultSetExtractor.EmployeeResultSetExtractor;
import com.JdbcMssql.EmployeeCRUD.ResultSetExtractor.EmployeesListResultSetExtractor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private ModelMapper mapper;

    public EmployeeDaoImpl(DataSource dataSource){
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private EmployeeDto mapToDto(Employee employee){
        EmployeeDto employeeDto = mapper.map(employee, EmployeeDto.class);
        return employeeDto;
    }

    private Employee mapToEntity(EmployeeDto employeeDto){
        Employee employee = mapper.map(employeeDto, Employee.class);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT id, name, email FROM Employee";
        return namedParameterJdbcTemplate.query(sql, new EmployeesListResultSetExtractor());
    }

    @Override
    public Employee getEmployeeById(int id) {
        String sql = "SELECT id, name, email FROM Employee WHERE id = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        return namedParameterJdbcTemplate.query(sql, namedParameters, new EmployeeResultSetExtractor());
    }

    @Override
    public Employee insertNewEmployee(Employee employee) {
        String sql = "INSERT INTO Employee(name, email) VALUES(:name, :email)";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("name", employee.getName())
                .addValue("email", employee.getEmail());
        namedParameterJdbcTemplate.update(sql, namedParameters);
        return employee;
    }

    @Override
    public Employee updateEmployeeById(int id, Employee employee) {
        String sql = "UPDATE Employee SET name = :name, email = :email WHERE id = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", employee.getId())
                .addValue("name", employee.getName())
                .addValue("email", employee.getEmail());
        int update = namedParameterJdbcTemplate.update(sql, namedParameters);
        if(update == 1){
            System.out.println("New record is updated");
        }
        else{
            System.out.println("New record is not updated");
        }
        return employee;
    }

    @Override
    public Employee updateEmployeeNameField(int id, Employee employee) {
        String sql = "UPDATE Employee SET name = :name WHERE id = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", employee.getId())
                .addValue("name", employee.getName());
        int rowsAffected = namedParameterJdbcTemplate.update(sql, namedParameters);
        if(rowsAffected == 1){
            sql = "SELECT * FROM Employee WHERE id = :id";
            namedParameters = new MapSqlParameterSource()
                    .addValue("id", id);
            return namedParameterJdbcTemplate.query(sql, namedParameters, new EmployeeResultSetExtractor());
        }
        else {
            return null;
        }
    }

    @Override
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM Employee WHERE id = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", id);
        namedParameterJdbcTemplate.update(sql, namedParameters);
    }
}
