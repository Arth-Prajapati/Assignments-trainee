package com.aimdek.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aimdek.dao.studentdao;

@Controller
public class DeleteController {
	
	@Autowired
	private studentdao studentdao;

	@RequestMapping(value = "/delete/{studentId}")
	public ModelAndView deleteStudentById(ModelAndView mv, @PathVariable("studentId") String studentid)
			throws IOException {

		studentdao.studentdelete(studentid);

		mv.setViewName("delete");

		return mv;
	}

	
	
}
