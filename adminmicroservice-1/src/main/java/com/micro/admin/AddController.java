package com.micro.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/admin")
public class AddController {
	
@Autowired
RestTemplate rest;

@Autowired
ServiceClass service;

@GetMapping("/getlecturer")
public ModelAndView lecturer() {
	ModelAndView mv=new ModelAndView("lecturer");
	return mv;
}
@GetMapping("/home")
public ModelAndView lecturerHome() {
	ModelAndView mv=new ModelAndView("home");
	return mv;
}
@GetMapping("/login")
public ModelAndView adminLogin() {
	ModelAndView mv=new ModelAndView("adminlogin");
	
	return mv;
}
@GetMapping("/getunits")
public ModelAndView units() {
ModelAndView mv=new ModelAndView("units");
 
	
return mv;
}
@GetMapping("/register")
public ModelAndView register() {
ModelAndView mv=new ModelAndView("adminregister");
return mv;
}
@PostMapping("/addlecturer")
@ResponseBody
public ModelAndView add(Lecturer lec) {
	ModelAndView mv=new ModelAndView();
    rest.postForObject("http://lecturer-service/lecturer/save",lec,Lecturer.class);
    mv.addObject("message","inserted!");
	mv.setViewName("lecturer");
	return mv;
}
@PostMapping("/addunits")
@ResponseBody
public ModelAndView add(Units unit) {
	ModelAndView mv=new ModelAndView();
    String message=service.addUnits(unit);
    mv.addObject("message",message);
	mv.setViewName("units");
	return mv;
}

@PostMapping("/addadmin")
public ModelAndView add(Admin admin) {
	ModelAndView mv=new ModelAndView();
    service.addAdmin(admin);
	mv.setViewName("adminlogin");
	return mv;
}
@PostMapping("/login")
public ModelAndView login(@RequestParam String userName,@RequestParam String password) {
	ModelAndView mv=new ModelAndView();
	Admin admin=service.login(userName,password);
	if(admin!=null) {
		mv.addObject("admin",admin);
		mv.setViewName("welcomeadmin");
	}else {
		mv.setViewName("adminlogin");
	}
	
	return mv;
	
}
@RequestMapping("/viewunits")
public ModelAndView getAll(){
	ModelAndView mv=new ModelAndView();
	List<Units> myList=service.findAll();
	mv.addObject("unitslist",myList);
	mv.setViewName("viewunits");
	return mv;
}
@RequestMapping("/getunits/{department}/{year}")
public MyUnits getUnits(@PathVariable String department,@PathVariable int year) {
	List<Units> myList=service.findAll(department,year);
	MyUnits unit=new MyUnits();
	unit.setMyUnits(myList);
	return unit;
}
@RequestMapping("/deleteunit")
public ModelAndView delete(@RequestParam String unitCode) {
	ModelAndView mv=new ModelAndView();
	service.deleteUnit(unitCode);
	List<Units> myList=service.findAll();
	mv.addObject("unitslist",myList);
	mv.setViewName("viewunits");
	return mv;
}
@RequestMapping("/deletelecturer")
@ResponseBody
public ModelAndView deleteLec(@RequestParam String lecturerId) {
	ModelAndView mv=new ModelAndView();
	rest.delete("http://lecturer-service/lecturer/deletelecturer/" + lecturerId);
	MyLecturer lec=rest.getForObject("http://lecturer-service/lecturer/getLecturers", MyLecturer.class);
	List<Lecturer> myList=lec.getMyList();
	mv.addObject("myList", myList);
	mv.setViewName("lecturerview");
	return mv;
}
@RequestMapping("/viewlecturer")
public ModelAndView lecturerView() {
	ModelAndView mv=new ModelAndView();
	MyLecturer lec=rest.getForObject("http://lecturer-service/lecturer/getLecturers", MyLecturer.class);
	List<Lecturer> myList=lec.getMyList();
    mv.addObject("myList", myList);
    mv.setViewName("lecturerview");
	return mv;
}
}
