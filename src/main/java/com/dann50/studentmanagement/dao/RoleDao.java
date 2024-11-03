package com.dann50.studentmanagement.dao;

import com.dann50.studentmanagement.entity.Role;

public interface RoleDao {
	
	Role findRoleByName(String theRoleName);
}
