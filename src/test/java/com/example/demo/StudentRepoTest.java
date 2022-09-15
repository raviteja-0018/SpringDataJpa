package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Guardian;
import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepo;


@SpringBootTest
//@DataJpaTest
@TestMethodOrder(value=OrderAnnotation.class)
class StudentRepoTest {

	@Autowired
	private StudentRepo studentRepo;
	
	@Test
	@Order(value = 1)
	void saveStudent()
	{
		Student student= Student.builder()
				.emailId("abc@gmail.com")
				.firstName("abc")
				.lastName("xyz")
				//.guardianName("manish")
				//.guerdianEmail("manish@gmail.com")
				//.guardianMobile("987654321")
				.build();
		
		studentRepo.save(student);

				
	}
	
	@Test
	@Order(value = 2)
	void saveStudentWithGuardian()
	{
	    Guardian guardian=Guardian.builder()
	    		.name("prakash")
	    		.email("pra@gmail.com")
	    		.mobile("32453654")
	    		.build();
		
		Student student=Student.builder()
				.emailId("abc123@gmail.com")
				.firstName("puma")
				.lastName("kole")
				.guardian(guardian)
				.build();
		
		studentRepo.save(student);
		
	}
	
	@Test
	@Order(value=3)
	void printAll()
	{
		List<Student> stu=studentRepo.findAll();
		System.out.println(stu);
	}
	
	@Test
	void findByStudentNameContaining()
	{
		List<Student> students=studentRepo.findByFirstNameContaining("m");
		
		System.out.println(students);
	}
	
	@Test
	void findByFirstNameStartingWith()
	{
		List<Student> students=studentRepo.findByFirstNameStartingWith("a");
		
		System.out.println(students);
	}
	
	@Test
	void getStudentByEmail()
	{
		Student student=studentRepo.getStudentByEmailAddress("abc123@gmail.com");
		
		System.out.println(student);
	}
	
	@Test
	void getStudentByEmail1()
	{
		List<String> student=studentRepo.getStudentByEmailAddress1("abc123@gmail.com");
		
		System.out.println(student);
	}
	
	@Test
	void getStudentFirstNameByEmailAddress()
	{
		String name=studentRepo.getStudentFirstNameByEmailAddress("abc123@gmail.com");
		System.out.println(name);
	}

}
