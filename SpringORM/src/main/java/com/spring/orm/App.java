package com.spring.orm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Consumer;

import javax.transaction.Transactional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.util.SystemPropertyUtils;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.dao.StudentDaoImpl;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */

public class App {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/orm/resource/config.xml");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StudentDao studentDao = (StudentDao) context.getBean("test2", StudentDao.class);
		
		/*HibernateTemplate ht = context.getBean("hibernateTemplate", HibernateTemplate.class);
		System.out.println(ht);
		Student st = context.getBean("student", Student.class);
		System.out.println(st);
		StudentDaoImpl dao = context.getBean("test2", StudentDaoImpl.class);
		System.out.println(dao);
		System.out.println(studentDao);*/
	

		System.out.println("**********************Student Management System*********************");
		boolean go = true;
		while (go) {

			System.out.println("Press 1 For New Student :");
			System.out.println("Press 2 For Update Existing Student :");
			System.out.println("Press 3 For Delete Student :");
			System.out.println("Press 4 For Get Student :");
			System.out.println("Press 5 For Get All Student :");
			System.out.println("Press 6 For Exit :");
			try {
				int input = Integer.parseInt(br.readLine());
				switch (input) {
				case 1:
					Student student = new Student();
					System.out.println("Enter Student Id :");
					int id = Integer.parseInt(br.readLine());
					student.setId(id);
					System.out.println("Enter Student Name :");
					String name = br.readLine();
					student.setName(name);
					System.out.println("Enter City :");
					String city = br.readLine();
					student.setCity(city);
					int i = studentDao.insert(student);
					System.out.println("id of row inserted : " + i);
					break;
				case 2:
					System.out.println("Enter Student id :");
					int uid = Integer.parseInt(br.readLine());
					System.out.println("Enter Student name :");
					String uName = br.readLine();
					studentDao.updateStudent(uid, uName);
					System.out.println("Student Updated..");

					break;
				case 3:
					System.out.println("Enter Id to delete Student :");
					int sid = Integer.parseInt(br.readLine());
					studentDao.deleteStudent(sid);
					System.out.println("Student deleted..");
					break;
				case 4:
					System.out.println("Enter Student Id :");
					int ssid = Integer.parseInt(br.readLine());
					Student stud = studentDao.getStudent(ssid);
					System.out.println("Student Id \t Student Name \t Student City ");
					System.out.println(stud.getId() + " : " + stud.getName() + " : " + stud.getCity());
					break;

				case 5:
					List<Student> listOfStudent = studentDao.getallStudents();
					listOfStudent.stream().forEach(System.out::println);

					break;
				case 6:
					go = false;
					break;

				}
			} catch (IOException e) {
				System.out.println("Invalid Input try with another one ...");
				e.printStackTrace();
			}

		}

	}
}
