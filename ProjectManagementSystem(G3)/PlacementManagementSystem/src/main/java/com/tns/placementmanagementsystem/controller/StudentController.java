package com.tns.placementmanagementsystem.controller;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.tns.placementmanagementsystem.entity.Student;
import com.tns.placementmanagementsystem.services.StudentService;


@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;	
	
	//For All List
	@GetMapping("/student")
	 public List<Student> list() 
	 {
	 return service.listAll();
	 }
	
	 //For Search By ID
	 @GetMapping("/student/{id}")
	 public ResponseEntity<Student> get(@PathVariable long id) 
	 {
	 try
	 {
	 Student student = service.get(id);
	 return new ResponseEntity<Student>(student, HttpStatus.OK);
 		} 
		catch (NoSuchElementException e) 
	 {
	 return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
	 } 
	 }
	 
	//For Search By HallTicketNo
//		 @GetMapping("/student/{id}")
//		 public ResponseEntity<Student> get(@PathVariable long hallTicketNo) 
//		 {
//		 try
//		 {
//			Student student = service.get(hallTicketNo);
//		 return new ResponseEntity<Student>(student, HttpStatus.OK);
//		 } 
//		 catch (NoSuchElementException e) 
//		 {
//		 return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
//		 } 
//		 }
	
	 //For Create operation
	 @PostMapping("/student")
	 public void add(@RequestBody Student student) 
	 {
	
	service.save(student);
	 }
	 
	 //For Update operation
	 @PutMapping("/student/{id}")
	 public ResponseEntity<?> update(@RequestBody Student student, @PathVariable Long id) 
	 {
	 try
	 {
     service.save(student);
	 return new ResponseEntity<>(HttpStatus.OK);
	 } 
	 catch (NoSuchElementException e) 
	 {
	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 } 
	 }
	 // RESTful API method for Delete operation
	 @DeleteMapping("/student/{id}")
	 public void delete(@PathVariable Long id) 
	 {
	 service.delete(id);
	 }
	
	
	
	
	
	
	
	
	
	

}
