package com.dann50.studentmanagement.config;

import com.dann50.studentmanagement.service.StudentService;
import com.dann50.studentmanagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

	@Bean
	public AuthenticationManager authManager(AuthenticationManagerBuilder auth) throws Exception {
		//student and teacher login credentials are stored in mysql db, while admin username and password defined below as in-memory

		auth
        	.userDetailsService(studentService)
        	.passwordEncoder(passwordEncoder());
		auth
        	.userDetailsService(teacherService)
        	.passwordEncoder(passwordEncoder());

		auth.inMemoryAuthentication()  //admin password username
        .withUser("admin")
        .password(passwordEncoder().encode("1"))
        .roles("ADMIN");

		return auth.build();
	}
	
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http
			.userDetailsService(teacherService)
			.userDetailsService(studentService)
			.authorizeHttpRequests(c ->
				c
					.requestMatchers("/").authenticated()
					.requestMatchers("/admin/**").hasRole("ADMIN")
					.requestMatchers("/student/**").hasRole("STUDENT")
					.requestMatchers("/teacher/**").hasRole("TEACHER"))
			.formLogin(c ->
				c
					.loginPage("/showLoginPage") //custom login page is generated in LoginController
					.loginProcessingUrl("/authenticateTheUser") //authenticateTheUser is automatically done by spring boot
					.successHandler(customAuthenticationSuccessHandler) //after login, user is redirected to home page depending on the role.
					.permitAll())
			.logout(c -> c.permitAll())
			.exceptionHandling(c -> c.accessDeniedPage("/access-denied"));
			 //simple access denied mapping defined in LoginController in case of user

		return http.build();
	}
	
	
	//needed for admin password encoding for security purposes
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	

}


