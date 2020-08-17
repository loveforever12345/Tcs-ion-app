package com.example.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Services.IStudentDataService;
import com.example.model.StudentDataModel;



@Controller
@RequestMapping(value="/user")
public class StudentDataController {
	private static final Logger logger = LogManager.getLogger(StudentDataController.class);
	@Autowired
	private IStudentDataService studentDataService;
	
	@GetMapping(value="/getstudentdata",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StudentDataModel>> getAllstudentData() {
		List<StudentDataModel> list = studentDataService.getAllstudentData();
		return new ResponseEntity<List<StudentDataModel>>(list, HttpStatus.OK);
	}
	@GetMapping(value="/save-student/{studentname}/{branch}/{batch}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveStudent(
			@PathVariable("studentname") String studentname,
			@PathVariable("branch") String branch,
			@PathVariable("batch") String batch) {
			Object data =studentDataService.saveStudent(studentname,branch,batch);
			return new ResponseEntity<Object>(data,HttpStatus.OK);
		
	}
	
	@GetMapping("/delete-student/{id}")
	public ResponseEntity<Object> deleteStudent(@PathVariable("id") int id) {
		Object data = studentDataService.deleteStudent(id);
		return new ResponseEntity<Object>(data,HttpStatus.OK);
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<List<StudentDataModel>> allstudentByID(@PathVariable("id") int id) {
		List<StudentDataModel> list = studentDataService.getStudentByID(id);
		return new ResponseEntity<List<StudentDataModel>>(list, HttpStatus.OK);
		
	}
	
	@GetMapping("/update-student/{id}/{studentname}/{branch}/{batch}")
	public ResponseEntity<Object> updateStudent(@PathVariable("id") int id,
			@PathVariable("studentname") String studentname,
			@PathVariable("branch") String branch,
			@PathVariable("batch") String batch) {
		Object data = studentDataService.updateStudent(id,studentname,branch,batch);
		return new ResponseEntity<Object>(data,HttpStatus.OK);

	}
}
