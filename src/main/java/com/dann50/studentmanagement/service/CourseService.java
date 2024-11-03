package com.dann50.studentmanagement.service;

import java.util.List;

import com.dann50.studentmanagement.entity.Course;

public interface CourseService {
	
	void save(Course course);
	
	List<Course> findAllCourses();
	
	Course findCourseById(int id);
	
	void deleteCourseById(int id);
}
