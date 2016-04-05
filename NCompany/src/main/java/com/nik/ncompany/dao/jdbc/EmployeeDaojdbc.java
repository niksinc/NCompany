package com.nik.ncompany.dao.jdbc;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nik.ncompany.dao.EmployeeDao;
import com.nik.ncompany.domain.Employee;

@Repository("employeeDaojdbc")
@Transactional
public class EmployeeDaojdbc implements EmployeeDao {

	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate dbTemplate;
	private SimpleJdbcInsert jdbcInsert;
	private EmployeeRowMapper employeeRowMapper;

	@PostConstruct
	public void setup() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		dbTemplate = new NamedParameterJdbcTemplate(dataSource);
		employeeRowMapper = new EmployeeRowMapper();
		jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("employee").usingGeneratedKeyColumns("empId")
				.usingColumns("fName", "lName", "email", "phoneNumber");
	}

	@Override
	public Employee findEmployeeById(int empId) {
		String sql = "select * FROM employee WHERE empId =:empId";
		MapSqlParameterSource params = new MapSqlParameterSource("empId", empId);
		List<Employee> matchingEmployee = dbTemplate.query(sql, params, employeeRowMapper);
		if (matchingEmployee.size() == 0) {
			return null;
		}
		return matchingEmployee.get(0);

	}

	@Override
	public Employee findEmployeeByName(String fName) {
		String sql = "select * FROM employee WHERE fName =:fName";
		MapSqlParameterSource params = new MapSqlParameterSource("fName", fName);
		List<Employee> matchingEmployee = dbTemplate.query(sql, params, employeeRowMapper);
		if (matchingEmployee.size() == 0) {
			return null;
		}
		return matchingEmployee.get(0);
	}

	@Override
	public Employee findEmployeeByEmail(String email) {
		String sql = "select * FROM employee WHERE email =:email";
		MapSqlParameterSource params = new MapSqlParameterSource("email", email);
		List<Employee> matchingEmployee = dbTemplate.query(sql, params, employeeRowMapper);
		if (matchingEmployee.size() == 0) {
			return null;
		}
		return matchingEmployee.get(0);

	}

	@Override
	public void insertEmployee(Employee employee) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(employee);
		System.out.println("params are " + params);
		Number newId = jdbcInsert.executeAndReturnKey(params);
		employee.setEmpId(newId.intValue());
	}

	@Override
	public void deleteEmployee(Employee employee) {
		String sql = "delete from employee where empId=?";
		jdbcTemplate.update(sql, Integer.valueOf(employee.getEmpId()));

	}

	@Override
	public int updateEmployee(int empId, Employee employee) {
		String sql = "update employee  set fName=:fName ,lName=:lName,phoneNumber=:phoneNumber, email=:email where empId=:empId";
		String fName, lName, phoneNumber, email;

		MapSqlParameterSource params;
		int rowsAffected;

		fName = employee.getfName();
		lName = employee.getlName();
		email = employee.getEmail();
		phoneNumber = employee.getPhoneNumber();

		params = new MapSqlParameterSource("empId", empId);
		params.addValue("fName", fName);
		params.addValue("lName", lName);
		params.addValue("phoneNumber", phoneNumber);
		params.addValue("email", email);

		rowsAffected = dbTemplate.update(sql, params);

		return rowsAffected;

	}

	@Override
	public int getEmployeeCount() {
		String sql = "select count(*) FROM employee";
		return jdbcTemplate.queryForObject(sql, Integer.class);

	}

	@Override
	public List<Employee> getEmployeeList() {
		String sql = "SELECT * FROM employee";
		List<Employee> employeeList = jdbcTemplate.query(sql, employeeRowMapper);
		return employeeList;

	}

}
