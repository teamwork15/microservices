package com.micro.lecturrer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LecturerService {

	@Autowired
	LecturerRepo repo;
	
	@Autowired
	MarksRepo mrepo;

	public void save(Lecturer lec) {
		repo.save(lec);
		
	}

	public void deleteLec(String lecturerId) {
		repo.deleteByLecturerId(lecturerId);
		}

	public String saveMarks(Marks mark) {
		String message="";
	mrepo.save(mark);
		if(mrepo.save(mark)!=null) {
			message="marks inserted!";
		}else {
			message="failed to insert!";
		}
		return message;
	}

	public List<Marks> getMarks(String regno) {
		
		return mrepo.getMarks(regno);
	}

	public Lecturer login(String lecturerId, String password) {
		return repo.findByLecturerIdAndPassword(lecturerId,password);
		
	}

	public List<Lecturer> getAll() {
		
		return repo.findAll();
	}
	
}
