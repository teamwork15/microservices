package com.micro.lecturrer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping("/addmarks")
	public ModelAndView addMarks() {
	ModelAndView mv=new ModelAndView("addmarks");
	return mv;
		}
}
