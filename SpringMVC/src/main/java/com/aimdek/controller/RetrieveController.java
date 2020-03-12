package com.aimdek.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aimdek.dao.studentdao;
import com.aimdek.model.student;

@Controller
public class RetrieveController {
	
	@Autowired
	private studentdao studentdao;
	
	@RequestMapping(value="/retrieve")
	public ModelAndView readStudent(ModelAndView model) throws IOException {

		List<student> listStudent = studentdao.retrieve();
		model.addObject("listStudent", listStudent);
		model.setViewName("retrieve");

		return model;
	}

}
