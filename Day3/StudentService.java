package com.example.demo.dbconnect;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

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

}
