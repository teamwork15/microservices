package com.micro.admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UnitsRepo extends JpaRepository<Units,String>{

@Query(value="select * from units where department=?1 and year=?2",nativeQuery=true)
public List<Units> findUnits(String department, int year);

}
