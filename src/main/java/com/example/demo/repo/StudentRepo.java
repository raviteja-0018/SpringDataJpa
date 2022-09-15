package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{

	
	public List<Student> findByFirstNameContaining(String firstName);

    List<Student> findByLastNameAndFirstName(String ln,String fn);
    
    List<Student> findByFirstNameStartingWith(String s);
    
    @Query("select s from Student s where s.emailId=?1")
    Student getStudentByEmailAddress(String email);
    
    @Query("select emailId,lastName from Student where emailId=?1")
    List<String> getStudentByEmailAddress1(String email);
    
    @Query("select firstName from Student  where emailId=?1")
    String getStudentFirstNameByEmailAddress(String email);
}
