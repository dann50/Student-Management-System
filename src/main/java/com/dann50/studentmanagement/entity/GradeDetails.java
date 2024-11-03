package com.dann50.studentmanagement.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Table
@Entity(name = "grade_details")
public class GradeDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;
	
	@Column(name="grade_one")
	public Integer gradeOne;
	
	@Column(name="grade_two")
	public Integer gradeTwo;
	
	@Column(name="grade_three")
	public Integer gradeThree;
	
	@OneToOne(mappedBy="gradeDetails", 
			cascade= {CascadeType.DETACH, CascadeType.MERGE,
					CascadeType.PERSIST, CascadeType.REFRESH})
	private StudentCourseDetails studentCourseDetails;
	
	public GradeDetails() {
		
	}

	public GradeDetails(int id, int gradeOne, int gradeTwo, int gradeThree) {
		this.id = id;
		this.gradeOne = gradeOne;
		this.gradeTwo = gradeTwo;
		this.gradeThree = gradeThree;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGradeOne() {
		if(gradeOne == null) {
			return -1;
		} else {
			return gradeOne;
		}
	}

	public void setGradeOne(int gradeOne) {
		this.gradeOne = gradeOne;
	}

	public int getGradeTwo() {
		if(gradeTwo == null) {
			return -1;
		} else {
			return gradeTwo;
		}
	}

	public void setGradeTwo(int gradeTwo) {
		this.gradeTwo = gradeTwo;
	}

	public int getGradeThree() {
		if(gradeThree == null) {
			return -1;
		} else {
			return gradeThree;
		}
	}

	public void setGradeThree(int gradeThree) {
		this.gradeThree = gradeThree;
	}

	public StudentCourseDetails getStudentCourseDetails() {
		return studentCourseDetails;
	}

	public void setStudentCourseDetails(StudentCourseDetails studentCourseDetails) {
		this.studentCourseDetails = studentCourseDetails;
	}
	
	
}





