package com.dann50.studentmanagement.service;

import java.util.List;

import com.dann50.studentmanagement.entity.Student;
import com.dann50.studentmanagement.user.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface StudentService extends UserDetailsService {
	
	Student findByStudentName(String userName);

	void save(UserDto userDto);
	
	void save(Student student);
	
	Student findByStudentId(int id);
	
	List<Student> findAllStudents();
	
	void deleteById(int id);
}
