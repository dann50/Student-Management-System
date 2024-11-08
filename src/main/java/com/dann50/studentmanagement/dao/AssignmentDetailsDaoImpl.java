package com.dann50.studentmanagement.dao;

import com.dann50.studentmanagement.entity.AssignmentDetails;
import jakarta.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AssignmentDetailsDaoImpl implements AssignmentDetailsDao {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public AssignmentDetails findByAssignmentAndStudentCourseDetailsId(int assignmentId,
																	   int studentCourseDetailsId) {
		Session session = entityManager.unwrap(Session.class);
		Query<AssignmentDetails> query = session
				.createQuery("from assignment_details where assignmentId=:assignmentId AND studentCourseDetailsId=:detailsId", 
				AssignmentDetails.class);
		query.setParameter("assignmentId", assignmentId);
		query.setParameter("detailsId", studentCourseDetailsId);
		
		
		AssignmentDetails s = query.getSingleResult(); 
		
		return s;
		
		
		
	}

	@Override
	public void save(AssignmentDetails studentCourseAssignmentDetails) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(studentCourseAssignmentDetails);
	}

}
