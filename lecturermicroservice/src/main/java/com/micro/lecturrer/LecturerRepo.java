package com.micro.lecturrer;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface LecturerRepo extends JpaRepository<Lecturer,String>{
@Modifying
@Transactional
@Query(value="delete from lecturer where lecturer_id=?1",nativeQuery=true)
public void deleteByLecturerId(String lecturerId);

public Lecturer findByLecturerIdAndPassword(String lecturerId, String password);

}
