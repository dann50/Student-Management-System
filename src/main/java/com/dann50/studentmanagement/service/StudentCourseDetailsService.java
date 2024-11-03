package com.dann50.studentmanagement.service;

import java.util.List;

import com.dann50.studentmanagement.entity.StudentCourseDetails;

public interface StudentCourseDetailsService {
	
	List<StudentCourseDetails> findByStudentId(int id);
	
	StudentCourseDetails findByStudentAndCourseId(int studentId, int courseId);
	
	void deleteByStudentId(int id);
	
	void deleteByStudentAndCourseId(int studentId, int courseId);
	
	void save(StudentCourseDetails studentCourseDetails);
}
