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
import org.springframework.transaction.annotation.Transactional;

import com.nik.ncompany.dao.ProjectDao;
import com.nik.ncompany.domain.Project;

@Repository("projectDaojdbc")
@Transactional
public class ProjectDaojdbc implements ProjectDao {

	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate dbTemplate;
	private SimpleJdbcInsert jdbcInsert;
	private ProjectRowMapper projectRowMapper;

	@PostConstruct
	public void setup() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		dbTemplate = new NamedParameterJdbcTemplate(dataSource);
		projectRowMapper = new ProjectRowMapper();
		jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("project").usingGeneratedKeyColumns("projId")
				.usingColumns("projName", "startDate", "endDate", "deptId");
	}

	@Override
	public Project findProjectById(int projId) {
		String sql = "select * FROM project WHERE projId =:projId";
		MapSqlParameterSource params = new MapSqlParameterSource("projId", projId);
		List<Project> matchingProject = dbTemplate.query(sql, params, projectRowMapper);
		if (matchingProject.size() == 0) {
			return null;
		}
		return matchingProject.get(0);

	}

	@Override
	public Project findProjectByName(String projName) {
		String sql = "select * FROM project WHERE projName =:projName";
		MapSqlParameterSource params = new MapSqlParameterSource("projName", projName);
		List<Project> matchingProject = dbTemplate.query(sql, params, projectRowMapper);
		if (matchingProject.size() == 0) {
			return null;
		}
		return matchingProject.get(0);

	}

	@Override
	public void insertProject(Project project) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(project);
		System.out.println("params are " + params.getValue("startDate"));
		Number newId = jdbcInsert.executeAndReturnKey(params);
		project.setProjId(newId.intValue());

	}

	@Override
	public void deleteProject(Project project) {

		String sql = "delete from project where projId=?";
		jdbcTemplate.update(sql, Integer.valueOf(project.getProjId()));
	}

	@Override
	public int updateProject(int projId, Project project) {
		String sql = "update project  set projName=:projName ,deptId=:deptId,startDate=:startDate, endDate=:endDate where projId=:projId";
		String projName;
		int deptId;
		String startDate, endDate;

		MapSqlParameterSource params;
		int rowsAffected;

		projName = project.getProjName();
		deptId = project.getdeptId();
		startDate = project.getStartDate();
		endDate = project.getEndDate();

		params = new MapSqlParameterSource("projId", projId);
		params.addValue("projName", projName);
		params.addValue("deptId", deptId);
		params.addValue("startDate", startDate);
		params.addValue("endDate", endDate);

		rowsAffected = dbTemplate.update(sql, params);

		return rowsAffected;

	}

	@Override
	public int getProjectCount() {
		String sql = "select count(*) FROM project";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public List<Project> getProjectList() {
		String sql = "SELECT * FROM project";
		List<Project> projectList = jdbcTemplate.query(sql, projectRowMapper);
		return projectList;
	}

}
