package com.dann50.studentmanagement.dao;

import java.util.List;

import com.dann50.studentmanagement.entity.Student;

public interface StudentDao {
	
	Student findByStudentName(String theStudentName);
	
	void save(Student student);
	
	
	Student findByStudentId(int id);
	
	List<Student> findAllStudents();
	
	void deleteById(int id);
}
