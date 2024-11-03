package com.dann50.studentmanagement.service;

import com.dann50.studentmanagement.entity.Assignment;
import com.dann50.studentmanagement.dao.AssignmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AssignmentServiceImpl implements AssignmentService {
	
	@Autowired
	private AssignmentDao assignmentDao;
	
	@Override
	@Transactional
	public void save(Assignment assignment) {
		assignmentDao.save(assignment);
	}

	@Override
	@Transactional
	public void deleteAssignmentById(int id) {
		assignmentDao.deleteAssignmentById(id);
	}

}
