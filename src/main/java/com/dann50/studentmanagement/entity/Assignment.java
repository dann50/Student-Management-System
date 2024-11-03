package com.dann50.studentmanagement.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="assignment")
public class Assignment implements Comparable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message="is required") 
	@Size(min=1, message="is required")
	@Column(name="name")
	private String name;
	
	@NotBlank(message="is required") 
	@Size(min=1, message="is required")
	@Column(name="description")
	private String description;
	
	@NotEmpty(message="is required")
	@Column(name="due_date")
	private String dueDate;
	
	@Column(name="days_remaining")
	private int daysRemaining;
	
	
	@ManyToMany
	@JoinTable(name="assignment_details",
				joinColumns = @JoinColumn(name="assignment_id"),
				inverseJoinColumns = @JoinColumn(name="student_course_details_id"))
	private List<StudentCourseDetails> courseDetails;
	
	public Assignment() {
		
	}

	

	



	public Assignment(int id, String name, String description, String dueDate, int daysRemaining,
			List<StudentCourseDetails> courseDetails) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.dueDate = dueDate;
		this.daysRemaining = daysRemaining;
		this.courseDetails = courseDetails;
	}







	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public int getDaysRemaining() {
		return daysRemaining;
	}

	public void setDaysRemaining(int daysRemaining) {
		this.daysRemaining = daysRemaining;
	}


	public List<StudentCourseDetails> getCourseDetails() {
		return courseDetails;
	}




	public void setCourseDetails(List<StudentCourseDetails> courseDetails) {
		this.courseDetails = courseDetails;
	}




	@Override
	public int compareTo(Object o) {
		Assignment comAss = (Assignment) o;
		if(this.daysRemaining != comAss.getDaysRemaining()) {
			return this.daysRemaining - comAss.getDaysRemaining();
		} else {
			return this.name.compareTo(comAss.getName());
		}
	}

	
	
	
	
}




