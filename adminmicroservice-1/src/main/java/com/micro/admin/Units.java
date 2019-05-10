package com.micro.admin;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Units {
	
@Id
private String unitCode;
private String unitTitle;
private String department;
private double credits;
private int year;
public String getUnitCode() {
	return unitCode;
}
public void setUnitCode(String unitCode) {  
	this.unitCode = unitCode;
}
public String getUnitTitle() {
	return unitTitle;
}
public void setUnitTitle(String unitTitle) {
	this.unitTitle = unitTitle;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public double getCredits() {
	return credits;
}
public void setCredits(double credits) {
	this.credits = credits;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}

}
