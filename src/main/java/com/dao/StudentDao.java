package com.dao;

import java.util.List;

import com.model.Student;

public interface StudentDao {

	
	public int insert(Student student);
	public Student getStudent(int sid);
	public List<Student> getAllStudents();
	public void deleteStudent(int sid);
	public void deleteAllStudents();
	public void updateStudent(Student student);
}
