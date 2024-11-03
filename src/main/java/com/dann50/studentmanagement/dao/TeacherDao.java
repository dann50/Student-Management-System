package com.dann50.studentmanagement.dao;

import java.util.List;

import com.dann50.studentmanagement.entity.Teacher;

public interface TeacherDao {
	
	Teacher findByTeacherName(String theTeacherName);
	
	Teacher findByTeacherId(int id);
	
	void save(Teacher teacher);
	
	List<Teacher> findAllTeachers();
	
	void deleteTeacherById(int id);
	
}
