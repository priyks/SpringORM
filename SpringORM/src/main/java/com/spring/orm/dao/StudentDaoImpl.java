package com.spring.orm.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDaoImpl implements StudentDao {
	
	private HibernateTemplate ht;

	public StudentDaoImpl() {
		super();
		System.out.println("StudentImpl");
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the ht
	 */
	public HibernateTemplate getHt() {
		return ht;
	}
	/**
	 * @param ht the ht to set
	 */
	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
    @Transactional
	public int insert(Student student) {
	       
	    Integer i=(Integer) ht.save(student);
		return i;
	}
    // get Single student using studentId
	public Student getStudent(int studentId) {
	 Student student=ht.get(Student.class, studentId);
		return student;
	}
	// get all students 
	public List<Student> getallStudents() {
		 List<Student> studentList=ht.loadAll(Student.class);
		return studentList;
	}
	
	@Transactional
	public void updateStudent(int studentId,String name) {
		Student student=ht.get(Student.class, studentId);
		student.setName(name);
		ht.update(student);
		
	}
	
	@Transactional
	public void deleteStudent(int studentId) {
		 Student student=ht.get(Student.class, studentId);
		 ht.delete(student);
	 	
	}
	
	

	
}
