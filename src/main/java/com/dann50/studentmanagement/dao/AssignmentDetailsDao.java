package com.dann50.studentmanagement.dao;

import com.dann50.studentmanagement.entity.AssignmentDetails;

public interface AssignmentDetailsDao {
	
	AssignmentDetails findByAssignmentAndStudentCourseDetailsId(int assignmentId, int studentCourseDetailsId);
	
	void save(AssignmentDetails studentCourseAssignmentDetails);
}
