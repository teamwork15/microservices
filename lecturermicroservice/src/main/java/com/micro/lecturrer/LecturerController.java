package com.micro.lecturrer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/ui")
public class LecturerController {
	@Autowired
	LecturerService service;
    @Autowired
    RestTemplate rest;
    
 @GetMapping("/home")
 public ModelAndView home() {
	 ModelAndView mv=new ModelAndView("home");
	 return mv; 
 }
 @GetMapping("/lecturerlogin")  
 public ModelAndView login() {
	 ModelAndView mv=new ModelAndView("lecturerlogin");
	 return mv;
 }
 @PostMapping("/lecturerlogin")
 public ModelAndView login2(@RequestParam String lecturerId,@RequestParam String password) {
	 ModelAndView mv=new ModelAndView();
	 Lecturer lecturer=service.login(lecturerId,password);
	 if(lecturer!=null) {
	 mv.addObject("lecturer", lecturer);
	 mv.setViewName("welcomelecturer");
	 }else {
		 mv.setViewName("lecturerlogin"); 
	 }
	 return mv;
 }
 @GetMapping("/addmarks")
 public ModelAndView home(@RequestParam String lecturerId) {
	 ModelAndView mv=new ModelAndView();
	 mv.addObject("lecturerId",lecturerId);
	 mv.setViewName("addmarks");
	 return mv;
 }
@PostMapping("/addmarks")
public ModelAndView addMarks(Marks mark,@RequestParam String lecturerId) {
ModelAndView mv=new ModelAndView();
mv.addObject("lecturerId", lecturerId);
mark.setLecturerId(lecturerId);
service.saveMarks(mark);
mv.setViewName("addmarks");
return mv;
	}
@RequestMapping("/viewcomplains")
public ModelAndView viewComplain(@RequestParam String lecturerId) {
ModelAndView mv=new ModelAndView();
Complain complain=rest.getForObject("http://student-service/student/getcomplain/" + lecturerId,Complain.class);
List<Protest> myList=complain.getMylist();
mv.addObject("myList",myList);
mv.setViewName("viewcomplains");
return mv;
}
}
