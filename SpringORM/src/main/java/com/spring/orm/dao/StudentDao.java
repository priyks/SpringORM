package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.spring.orm.entities.Student;

public interface StudentDao {
	
	
	public int insert(Student student);
	public Student getStudent(int studentId);
	public List<Student> getallStudents();
	public void updateStudent(int studentId,String name);
	public void deleteStudent(int studentId);

}
