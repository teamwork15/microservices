package com.micro.lecturrer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MarksRepo extends JpaRepository<Marks,String>{

@Query(value="select * from marks where regno=?1",nativeQuery=true)
public List<Marks> getMarks(String regno);

}
