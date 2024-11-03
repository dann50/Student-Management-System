package com.dann50.studentmanagement.service;

import com.dann50.studentmanagement.entity.Assignment;

public interface AssignmentService {
	
	void save(Assignment assignment);
	
	void deleteAssignmentById(int id);
}
