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
public class UpdateController {
	
	@Autowired
	public studentdao studentdao; 
	
	
	@RequestMapping(value = "/update/{studentid}", method = RequestMethod.POST)
	public ModelAndView updatestudent(@RequestParam("Id")String studentid, @RequestParam("name")String studentname, @RequestParam("course")String studentcourse , ModelAndView mv) {

		student student = new student();
		student.setStudentid(studentid);
		student.setStudentname(studentname);
		student.setStudentcourse(studentcourse);

		studentdao.studentupdate(student);

		mv.setViewName("update");

		return mv;

}
	
}
