package com.example.demo.dbconnect;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

//Pagenation
@GetMapping("/findall/{pageNo}/{pageSize}")
public List<Student> listing(@PathVariable("pageNo")int pageNo,@PathVariable("pageSize")int pageSize) {
	 return  stuservice.getDetails(pageNo, pageSize);
 }


// Sort by any field name
@GetMapping("/{field}")
private List<Student> StudentWithSort(@PathVariable String field){
	List<Student> allStudent = stuservice.findStudentWithSorting(field);
	return allStudent;
}

// Native Query
@GetMapping("/select/{selectwithid}")
private List<Student> selectwithid(@PathVariable int selectwithid){
	List<Student> selectid = stuservice.findQuery(selectwithid);
	return selectid;
}

//JQL Queries
@GetMapping("/q")
public List<Student> queryGetStudent(){
	return stuservice.queryStudent();
 }

@PutMapping("updateMarks/{marks}/{id}")
public void updateMarks(@PathVariable int marks, @PathVariable int id) {
stuservice.qupdate(marks, id);
}

@DeleteMapping("/deletequery/{id}")
public String deleteStud(@PathVariable int id) {
	   return stuservice.deleteStudentDetails(id);
}
}
