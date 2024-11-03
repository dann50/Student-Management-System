package com.dann50.studentmanagement.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Table
@Entity(name="student_course_details")
public class StudentCourseDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="student_id")
	private int studentId;
	
	@Column(name="course_id")
	private int courseId;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="assignment_details",
				joinColumns = @JoinColumn(name="student_course_details_id"),
				inverseJoinColumns = @JoinColumn(name="assignment_id"))
	private List<Assignment> assignments;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)  
	@JoinColumn(name="grade_details_id")
	private GradeDetails gradeDetails;
	
	public StudentCourseDetails() {
		
	}

	



	public StudentCourseDetails(int studentId, int courseId, List<Assignment> assignments,
			GradeDetails gradeDetails) {
		this.studentId = studentId;
		this.courseId = courseId;
		this.assignments = assignments;
		this.gradeDetails = gradeDetails;
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public int getStudentId() {
		return studentId;
	}



	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}



	public int getCourseId() {
		return courseId;
	}



	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}



	public List<Assignment> getAssignments() {
		return assignments;
	}
	
	public List<Assignment> getAssignmentsByOrder() {
		Collections.sort(assignments);
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}
	
	public void addAssignment(Assignment assignment) {
		if(assignments == null) {
			assignments = new ArrayList<>();
		}
		assignments.add(assignment);
	}
	
	public Assignment getAssignmentById(int assignmentId) {
		for(Assignment a : assignments) {
			if(a.getId() == assignmentId) {
				return a;
			}
		}
		
		return null;
	}





	public GradeDetails getGradeDetails() {
		return gradeDetails;
	}





	public void setGradeDetails(GradeDetails gradeDetails) {
		this.gradeDetails = gradeDetails;
	}

	
	
	
	
	
}


