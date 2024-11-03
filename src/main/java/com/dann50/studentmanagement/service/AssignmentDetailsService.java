package com.dann50.studentmanagement.service;

import com.dann50.studentmanagement.entity.AssignmentDetails;

public interface AssignmentDetailsService {
	
	AssignmentDetails findByAssignmentAndStudentCourseDetailsId(int assignmentId, int studentCourseDetailsId);
	
	void save(AssignmentDetails studentCourseAssignmentDetails);
}
