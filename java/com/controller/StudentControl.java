package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.repository.StudentRepository;


@RestController
public class StudentControl {

	@Autowired
	StudentRepository sr;
	
	
		@PostMapping("/savetheStudent")
		public String saveStudent(@RequestBody Student s) {
			sr.save(s);
			return "saved successfully";
		} 
			
				
		@GetMapping("/getStudentdata")
		public Student getStudent(@RequestParam int id) {
		Optional<Student> ou = sr.findById(id);
		 return ou.get();
		
	}
			
	     @GetMapping("/getalldata")
		 public List<Student> getAllstudents(){
		 return sr.findAll();
			}
			
		@DeleteMapping("/deleteStudentdata")
		public String deleteStudent(@RequestParam int id) {
		sr.deleteById(id);
		return "delete successfully";
	}
			
		@PutMapping("/updateStudentdata")
		public void updateUserData(@RequestBody Student s) {
		sr.save(s);
	}

}
