package com.micro.student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,String>{

public Student findByRegnoAndPassword(String regno, String password);

}
