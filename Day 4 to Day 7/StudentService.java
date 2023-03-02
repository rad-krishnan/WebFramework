package com.example.demo.dbconnect;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service

public class StudentService {

@Autowired

private StudentRepository stu;


public Student saveDetails(Student s)

{
return stu.save(s);
}

public List<Student> getAllDetails()
{
return stu.findAll();
}

public void deleteDepartmentById(int id)
{
stu.deleteById(id);
}

public List<Student> getDetails(int pageNo, int pageSize )
{
	
	
	
	Pageable pageable = PageRequest.of(pageNo, pageSize);
	Page<Student> page = stu.findAll(pageable);
	
	List<Student> id = page.getContent();
	return id;

}

public List<Student> findStudentWithSorting(String field){
	return stu.findAll(Sort.by(Sort.Direction.ASC, field));
}
public List<Student> findQuery(int selectwithid){
	return stu.findAllStudentNative(selectwithid);
}

public List<Student> queryStudent(){
	return stu.findAll();
}

public int qupdate(int marks, int id) {
	return stu.updateStudentMark(marks, id);
}
public String deleteStudentDetails(int id) {
	try {
		if(!stu.findById(id).isEmpty())
		{
			stu.deleteById(id);
			return "Student Detail Removed";
		}
		else
			throw new Exception("Error");
	}
	catch(Exception e) {
		e.printStackTrace();	
		return "No Student Found for Id "+id;
	}
}
}