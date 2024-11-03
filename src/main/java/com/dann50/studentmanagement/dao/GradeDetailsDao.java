package com.dann50.studentmanagement.dao;

import com.dann50.studentmanagement.entity.GradeDetails;

public interface GradeDetailsDao {
	
	void save(GradeDetails gradeDetails);
	
	GradeDetails findById(int id);
	
	void deleteById(int id);
}
