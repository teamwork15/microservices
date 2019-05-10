package com.micro.admin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,String>{

public Admin findByUserNameAndPassword(String userName,String password);
}
