package com.nik.ncompany.dao.jdbc;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nik.ncompany.dao.DepartmentDao;
import com.nik.ncompany.domain.Department;
import com.nik.ncompany.domain.Employee;

@Repository("departmentDaojdbc")
public class DepartmentDaojdbc implements DepartmentDao {

	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate dbTemplate;
	private SimpleJdbcInsert jdbcInsert;
	private DepartmentRowMapper departmentRowMapper;
	
	@PostConstruct
	public void setup() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		dbTemplate = new NamedParameterJdbcTemplate(dataSource);
		departmentRowMapper = new DepartmentRowMapper();
		jdbcInsert = new SimpleJdbcInsert(dataSource)
		                 .withTableName("department")
		                 .usingGeneratedKeyColumns("deptId")
		                 .usingColumns("deptName", "location");
	}

	@Override
	public Department findDepartmentById(int deptId) {
		String sql  ="select * FROM department WHERE deptId =:deptId";
		MapSqlParameterSource params = new MapSqlParameterSource("deptId",deptId);
		List<Department> matchingDepartment = dbTemplate.query(sql, params, departmentRowMapper);
		if (matchingDepartment.size() == 0) {
			return null;
		}
		return matchingDepartment.get(0);
		
	}

	@Override
	public Department findDepartmentByName(String deptName) {
		String sql  ="select * FROM department WHERE deptName =:deptName";
		MapSqlParameterSource params = new MapSqlParameterSource("deptName",deptName);
		List<Department> matchingDepartment = dbTemplate.query(sql, params, departmentRowMapper);
		if (matchingDepartment.size() == 0) {
			return null;
		}
		
		return matchingDepartment.get(0);
	}

	@Override
	public void insertDepartment(Department department) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(department);
		Number newId = jdbcInsert.executeAndReturnKey(params);
		department.setDeptId(newId.intValue());
		
	}

	@Override
	public void deleteDepartment(Department department) {
		String sql  ="delete from department where deptId=?";
		jdbcTemplate.update(sql,Integer.valueOf(department.getDeptId()));
		
	}

	@Override
	public int updateDepartment(int deptId, Department department) {
		String sql = "update department  set deptName=:deptName,location=:location where deptId=:deptId";
		String deptName,location;
		
		MapSqlParameterSource params;
		int rowsAffected;
		
		deptName = department.getDeptName();
		location = department.getLocation();
		
		params = new MapSqlParameterSource("deptId", deptId);
		params.addValue("deptName", deptName);
		params.addValue("location", location);
		rowsAffected = dbTemplate.update(sql, params);
		return rowsAffected;

	}

	@Override
	public int getDepartmentCount() {
		String sql = "select count(*) FROM department";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public List<Department> getDepartmentList() {
		String sql = "SELECT * FROM department";
		List<Department> departmentList = jdbcTemplate.query(sql, departmentRowMapper);
		return departmentList;
	}
	
	
	
}
