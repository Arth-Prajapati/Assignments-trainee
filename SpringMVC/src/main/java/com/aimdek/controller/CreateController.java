package com.aimdek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aimdek.dao.studentdao;
import com.aimdek.model.student;

@Controller
public class CreateController {
	
	@Autowired
	private studentdao studentdao;

	@RequestMapping(value="/create", method = RequestMethod.POST)
	public ModelAndView createstudent(@RequestParam("Id")String studentid, @RequestParam("name")String studentname, @RequestParam("course")String studentcourse , ModelAndView mv){
		
		student student = new student();
		
		student.setStudentid(studentid);
		student.setStudentname(studentname);
		student.setStudentcourse(studentcourse);
		
		studentdao.studentcreate(student);
		
		mv.setViewName("create");
		
		return mv;
	}
}
