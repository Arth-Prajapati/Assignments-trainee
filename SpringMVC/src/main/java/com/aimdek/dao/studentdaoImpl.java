package com.aimdek.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.aimdek.model.student;

public class studentdaoImpl implements studentdao{
	
private JdbcTemplate jdbctemplate;
	
	public studentdaoImpl(DataSource datasource) {
		jdbctemplate = new JdbcTemplate(datasource);
	}
	
	
	public void studentcreate(student student) {
		
		String sql = "insert into student.studentdata values(?,?,?)";
		
		jdbctemplate.update(sql,new Object[] {student.getStudentid(),student.getStudentname(),student.getStudentcourse()});
		
	}
	
	public List<student> retrieve() {
		
		List<student> studentlist = jdbctemplate.query("select * from student.studentdata", new RowMapper<student>() {
			
			public student mapRow(ResultSet rs, int rownum) throws SQLException{
				
				student student = new student();
				
				student.setStudentid(rs.getString("studentid"));
				student.setStudentname(rs.getString("studentname"));
				student.setStudentcourse(rs.getString("studentcourse"));
				
				return student;
			}
		});
		
		return studentlist;
		
	}
	
	public void studentupdate(student student) {
		
		String sql = "update student.studentdata set  studentname=?, studentcourse=? where studentid=?";
		
		jdbctemplate.update(sql,new Object[] {student.getStudentname(),student.getStudentcourse(),student.getStudentid()});
		
	}
	
	public void studentdelete(String studentid) {
		
		String sql = "delete from student.studentdata where studentid=?";
		
		jdbctemplate.update(sql,new Object[] {studentid});
		
	}

}
