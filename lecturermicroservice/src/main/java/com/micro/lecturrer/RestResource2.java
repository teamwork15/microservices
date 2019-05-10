package com.micro.lecturrer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lecturer")
public class RestResource2 {

	@Autowired
	LecturerService service;
	
@PostMapping("/save")
public void save(@RequestBody Lecturer lec) {
	service.save(lec);
}
@RequestMapping("/getLecturers")
public MyLecturer getLecturer() {
	List<Lecturer> myList=service.getAll();
	MyLecturer lec=new MyLecturer();
	lec.setMyList(myList);
	return lec;
}
@RequestMapping("/deletelecturer/{lecturerId}")	
public void delete(@PathVariable String lecturerId) {
	service.deleteLec(lecturerId);	
}
@RequestMapping("/getmarks/{regno}")
public UserMarks getMarks(@PathVariable String regno) {
	List<Marks> getMark=service.getMarks(regno);
	UserMarks mark=new UserMarks();
	mark.setMymarks(getMark);
	return mark;
}
}
