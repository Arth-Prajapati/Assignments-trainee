package com.aimdek.dao;

import java.util.List;

import com.aimdek.model.student;

public interface studentdao {
	
	public void studentcreate(student student);
	
	public List<student> retrieve();
	
	public void studentupdate(student student);
	
	public void studentdelete(String studentid);

}
