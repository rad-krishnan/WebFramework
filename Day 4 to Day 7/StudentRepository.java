package com.example.demo.dbconnect;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface StudentRepository extends JpaRepository<Student,Integer> {
	// Native Query, Index Query Parameter
	@Query(
			value = "select * from Student s where s.id = ?1",
			nativeQuery = true)
	List<Student> findAllStudentNative(int id);
	
	@Query("select s from Student s")
	List<Student> findAllStudentQuery();
	
	@Transactional
	@Modifying
	@Query("update Student s set s.marks = ?1 where s.id = ?2")
	int updateStudentMark(int marks, int id);
	
	@Modifying
	@Query(value="delete from Student s where s.id=:id")
	int deleteStudentDetails(@Param("id")int id);
	
}
