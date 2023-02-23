package com.example.demo.dbconnect;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentController {
@Autowired
private StudentService stuservice;

@PostMapping("/addStudent")
public String postDetails(@RequestBody Student s)
{
stuservice.saveDetails(s);
return "Value Added";

}

@GetMapping("/getStudent")
public List<Student> getDetails()
{

return stuservice.getAllDetails();
}
}