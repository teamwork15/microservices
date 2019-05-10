package com.micro.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/student")
public class RestResource {
	
@Autowired
ServiceClass service;

@Autowired
RestTemplate rest;

@GetMapping("/home")
public ModelAndView home() {
	ModelAndView mv=new ModelAndView("home");
	return mv;
}
@GetMapping("/units")
public ModelAndView units(@RequestParam String regno) {
	ModelAndView mv=new ModelAndView();
	mv.addObject("regno", regno);
	mv.setViewName("units");
	return mv;
}
@GetMapping("/sendcomplain")
public ModelAndView complain(@RequestParam String unitCode,@RequestParam String unitTitle,@RequestParam String lecturerId,@RequestParam String regno) {
	ModelAndView mv=new ModelAndView();
	mv.addObject("unitCode", unitCode);
	mv.addObject("unitTitle", unitTitle);
	mv.addObject("lecturerId", lecturerId);
	mv.addObject("regno", regno);
	mv.addObject("remark","Remark");
	mv.addObject("general","General");
	mv.addObject("missing","Missing-Marks");
	mv.setViewName("sendcomplain");
	return mv;
}
@GetMapping("/addstudent")
public ModelAndView add() {
	ModelAndView mv=new ModelAndView();
	mv.setViewName("addstudent");
	return mv;
}
@GetMapping("/studentlogin")
public ModelAndView addlogin() {
	ModelAndView mv=new ModelAndView();
	mv.setViewName("studentlogin");
	return mv;
}
@RequestMapping("/viewmarks")
public ModelAndView viewMarks(@RequestParam String regno) {
	ModelAndView mv=new ModelAndView();
	UserMarks mark=rest.getForObject("http://lecturer-service/lecturer/getmarks/"+ regno, UserMarks.class);
	List<Marks> myList=mark.getMymarks();
	mv.addObject("myList", myList);
	mv.addObject("regno", regno);
	mv.setViewName("viewmarks");
	return mv;
}
@GetMapping("/viewunits")
public ModelAndView viewMarks(@RequestParam String department,@RequestParam int year) {
	ModelAndView mv=new ModelAndView();
	MyUnits unit=rest.getForObject("http://admin-service/admin/getunits/"+department+"/"+year, MyUnits.class);
	List<Units> myList=unit.getMyUnits();
	mv.addObject("unitlist", myList);	
	mv.setViewName("viewunits");
	return mv;
}
@PostMapping("/addstudent")
public ModelAndView student(Student student) {
	ModelAndView mv=new ModelAndView();
	 service.addStudent(student);
	mv.setViewName("studentlogin");
	return mv;
}
@PostMapping("/loginstudent")
public ModelAndView login(@RequestParam String regno,String password) {
	ModelAndView mv=new ModelAndView();
	Student stud=service.loginStud(regno,password);
	if(stud!=null) {
		mv.addObject("student", stud);
		mv.setViewName("welcomestudent");	
	}else {
		mv.setViewName("studentlogin");
	}
	
	return mv;
}

@PostMapping("/sendcomplain")
public ModelAndView sendcomplain(@RequestParam String description,@RequestParam String type,@RequestParam String regno,
		@RequestParam String unitCode,@RequestParam String unitTitle,@RequestParam String lecturerId) {
	ModelAndView mv=new ModelAndView();
	Protest prot=new Protest();
	prot.setDescription(description);
	prot.setType(type);
	prot.setRegno(regno);
	prot.setUnitCode(unitCode);
	prot.setUnitTitle(unitTitle);
	prot.setLecturerId(lecturerId);
    String message=service.addComplain(prot);
	mv.addObject("message", message);
	mv.setViewName("sendcomplain");
	return mv;
	
}
@GetMapping("/mycomplain")
public ModelAndView send(@RequestParam String regno,
		@RequestParam String unitCode,@RequestParam String unitTitle,@RequestParam String lecturerId) {
	ModelAndView mv=new ModelAndView();
	mv.addObject("regno", regno);
	mv.addObject("unitCode",unitCode);
	mv.addObject("unitTitle", unitTitle);
	mv.addObject("lecturerId", lecturerId);
	mv.setViewName("sendcomplain");
	return mv;
}
@RequestMapping("/getcomplain/{lecturerId}")
public Complain getComplain(@PathVariable String lecturerId) {
	
Complain myComplain=new Complain();
List<Protest> myList=service.getALL(lecturerId);
myComplain.setMylist(myList);	
return myComplain;
}
}
