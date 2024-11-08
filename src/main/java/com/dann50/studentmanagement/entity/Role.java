package com.dann50.studentmanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	
	public Role() {
		
	}
	
	public Role(String name) {
		this.name = name;
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
	
	//overriding equals method in order to use contains method in CustomAuthenticationSuccessHadler class correctly 
	public boolean equals(Object comparedObject) {
	    
	    if (this == comparedObject) {
	        return true;
	    }

	   if (!(comparedObject instanceof Role)) {
	        return false;
	    }

	    Role comparedRole = (Role) comparedObject;

	    if (this.name.equals(comparedRole.name)) {
	        return true;
	    }

	    return false;
	}
}
