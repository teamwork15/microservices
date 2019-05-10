package com.micro.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceClass {

@Autowired
AdminRepo repo;

@Autowired
UnitsRepo urepo;

public String addAdmin(Admin admin) {
	String message="";
	repo.save(admin);
	if(repo.save(admin)!=null) {
		message="inserted!";
	}else {
		message="failed to insert!";
	}
	return message;
}

public Admin login(String userName, String password) {
	return repo.findByUserNameAndPassword(userName, password);
}

public String addUnits(Units unit) {
	
	String message="";
	urepo.save(unit);
	if(urepo.save(unit)!=null) {
		message="inserted!";
	}else {
		message="failed to insert!";
	}
	return message;
}

public void deleteUnit(String unitCode) {
	urepo.deleteById(unitCode);
	
}

public List<Units> findAll() {
	
return urepo.findAll();	
}

public List<Units> findAll(String department,int year) {
	
	return urepo.findUnits(department,year);
}

}
