package com;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.StudentDao;
import com.model.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context= new ClassPathXmlApplicationContext("config.xml");
        StudentDao sd = context.getBean("sdao", StudentDao.class);
        
//        Student student = new Student(102,"sakshi2","delhi2");
//        int r = sd.insert(student);
//        System.out.println("data inserted !!");
        
        
        Scanner sc= new Scanner(System.in);
        Boolean a=true;
        
        while(a)
        {
        System.out.println("press 1 to add new student");
        System.out.println("press 2 to display all students");
        System.out.println("press 3 to display single student data");
        System.out.println("press 4 to delete any student");
        System.out.println("press 5 to delete all students");
        System.out.println("press 6 to update student");
        System.out.println("press 7 to exit");
        
        try
        {
        	System.out.println("enter your choice !");
        	int input= sc.nextInt();
        	int id;
        	String name, city;
        	switch(input)
        	{
        	case 1:
        		
        		System.out.println("enter the id:");
        		id=sc.nextInt();
        		
        		System.out.println("enter the name");
        		name=sc.next();
        		
        		System.out.println("enter the city");
        		city=sc.next();
        		
        		Student s= new Student();
        		s.setSid(id);
        		s.setSname(name);
        		s.setScity(city);
        		
        		int r = sd.insert(s);
        		System.out.println("data inserted successfully !!");
        		
        		break;
        		
        	case 2:
        		
        		List<Student> students = sd.getAllStudents();
        		for(Student i: students)
        		{
        			System.out.println("Id : "+i.getSid());
        			System.out.println("Name : "+i.getSname());
        			System.out.println("City :"+i.getScity());
        		}
        		break;
        	
        	case 3:
        		System.out.println("enter the student id: ");
        		id=sc.nextInt();
        		Student s1 = sd.getStudent(id);
        		
        		System.out.println("Id : "+s1.getSid());
        		System.out.println("Name : "+s1.getSname());
        		System.out.println("City :"+s1.getScity());
        		
        		break;
        		
        	case 4:
        		
        		System.out.println("enter the id of student whose data top be deleted : ");
        		id=sc.nextInt();
        		
        		sd.deleteStudent(id);
        		System.out.println("Data deleted Succrssfully !! ");
        		
        		break;
        		
        	case 5:
        		
        		sd.deleteAllStudents();;
        		System.out.println("All Students data deleted successfully !!");
        		break;
        		
        	case 6:
        		
        		System.out.println("enter the student id whose data you wanna update");
        		id=sc.nextInt();
        		
        		System.out.println("enter the new name :");
        		name=sc.next();
        		
        		System.out.println("enter the enw city : ");
        		city=sc.next();
        		
        		Student s2 = new Student();
        		s2.setSid(id);
        		s2.setSname(name);
        		s2.setScity(city);
        		
        		sd.updateStudent(s2);
        		
        		System.out.println("Data updated successfully !! ");
        		
        		break;
        	
        	case 7:
        		a=false;
        		break;
        	}
        }
        catch(Exception e)
        {
        	System.out.println("invalid input !!");
        	System.out.println(e.getMessage());
        }
        }
    }
    
    
}
