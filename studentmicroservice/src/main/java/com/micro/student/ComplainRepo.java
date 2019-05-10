package com.micro.student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ComplainRepo extends JpaRepository<Protest,String>{

@Query(value="select * from protest where lecturer_id=?1",nativeQuery=true)
public List<Protest> getAll(String lecturerId);

}
