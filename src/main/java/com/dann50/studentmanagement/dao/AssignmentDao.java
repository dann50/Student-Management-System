package com.dann50.studentmanagement.dao;

import com.dann50.studentmanagement.entity.Assignment;

public interface AssignmentDao {
	
	void save(Assignment assignment);
	
	void deleteAssignmentById(int id);
}
