package com.micro.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceClass {

@Autowired
StudentRepo repo;

@Autowired
ComplainRepo crepo;

public String addStudent(Student student) {
String message="";
repo.save(student);
if(repo.save(student)!=null) {
	
	message="insert successful!";
	
	}else {
		
		message="failed to insert!";
		
	}
return message;
		
	}

public Student loginStud(String regno, String password) {
	
	return repo.findByRegnoAndPassword(regno,password);
}

public String addComplain(Protest prot) {
	String message="";
	crepo.save(prot);
	if(crepo.save(prot)!=null) {
		
		message="insert successful!";
		
		}else {
			
			message="failed to insert!";
			
		}
	return message;
			
	
}

public List<Protest> getALL(String lecturerId) {
	
	return crepo.getAll(lecturerId);
}	
}
