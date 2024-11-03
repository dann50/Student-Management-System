package com.dann50.studentmanagement.service;

import com.dann50.studentmanagement.entity.GradeDetails;

public interface GradeDetailsService {
	
	void save(GradeDetails gradeDetails);
	
	GradeDetails findById(int id);
	
	void deleteById(int id);
}
