package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.model.Student;

public class StudentDaoImpl implements StudentDao {

	
	private HibernateTemplate hibernateTemplate;
	
	
	public StudentDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDaoImpl(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public int insert(Student student) {
		int i= (Integer) hibernateTemplate.save(student);
		return i;
	}

	public Student getStudent(int sid) {
		Student student = hibernateTemplate.get(Student.class, sid);
		return student;
	}

	public List<Student> getAllStudents() {
		List<Student> students = hibernateTemplate.loadAll(Student.class);
		
		return students;
	}

	@Transactional
	public void deleteStudent(int sid) {
		
		Student student = hibernateTemplate.get(Student.class,sid );
		hibernateTemplate.delete(student);
	}
	
	@Transactional
	public void deleteAllStudents()
	{
		List<Student> students = hibernateTemplate.loadAll(Student.class);
		for(Student s:students)
		{
			hibernateTemplate.delete(s);
		}
		
	}

	@Transactional
	public void updateStudent(Student student) {
		hibernateTemplate.update(student);
		
	}
	
	

	
	
}
