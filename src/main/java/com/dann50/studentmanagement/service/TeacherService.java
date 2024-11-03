package com.dann50.studentmanagement.service;

import java.util.List;

import com.dann50.studentmanagement.entity.Teacher;
import com.dann50.studentmanagement.user.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface TeacherService extends UserDetailsService {
	
	Teacher findByTeacherName(String userName);
	
	Teacher findByTeacherId(int id);

	void save(UserDto userDto);
	
	void save(Teacher teacher);
	
	List<Teacher> findAllTeachers();
	
	void deleteTeacherById(int id);
}
