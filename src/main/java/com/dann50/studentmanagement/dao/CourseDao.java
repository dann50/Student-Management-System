package com.dann50.studentmanagement.dao;

import java.util.List;

import com.dann50.studentmanagement.entity.Course;

public interface CourseDao {
	
	void saveCourse(Course course);
	
	List<Course> findAllCourses();
	
	Course findCourseById(int id);
	
	void deleteCourseById(int id);
}
