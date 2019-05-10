package com.micro.student;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Protest {
	
@Id
private String unitCode;
private String unitTitle;
private String type;
private String description;
private String regno;
private String lecturerId;

public String getLecturerId() {
	return lecturerId;
}
public void setLecturerId(String lecturerId) {
	this.lecturerId = lecturerId;
}
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
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getRegno() {
	return regno;
}
public void setRegno(String regno) {
	this.regno = regno;
}



}
