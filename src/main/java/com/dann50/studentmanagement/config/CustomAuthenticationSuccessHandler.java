package com.dann50.studentmanagement.config;

import java.io.IOException;

import com.dann50.studentmanagement.entity.Teacher;
import com.dann50.studentmanagement.service.StudentService;
import com.dann50.studentmanagement.service.TeacherService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import com.dann50.studentmanagement.entity.Student;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private TeacherService teacherService;
	
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
		
		
		String role = auth.getAuthorities().iterator().next().toString();
		
		//redirecting the user to proper url depending on the authority
		if(role.equals("ROLE_STUDENT")) {
			String userName = auth.getName();
			Student theStudent = studentService.findByStudentName(userName);
			int userId = theStudent.getId(); //student id is a part of the url to get the current student in the controller class 
			HttpSession session = request.getSession();
			session.setAttribute("user", theStudent);
			response.sendRedirect(request.getContextPath() + "/student/" + userId + "/courses");
			
		} else if(role.equals("ROLE_TEACHER")) {
			String userName = auth.getName();
			Teacher theTeacher = teacherService.findByTeacherName(userName);
			int userId = theTeacher.getId();
			HttpSession session = request.getSession();
			session.setAttribute("user", theTeacher);
			response.sendRedirect(request.getContextPath() + "/teacher/" + userId + "/courses");
		} else { //if the role is admin
			response.sendRedirect(request.getContextPath() + "/admin/adminPanel");
		}

	}

}

