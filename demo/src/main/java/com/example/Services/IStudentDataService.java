package com.example.Services;

import java.util.List;

import com.example.model.StudentDataModel;

public interface IStudentDataService {
	List<StudentDataModel> getAllstudentData();

	boolean deleteStudent(int id);

	List<StudentDataModel> getStudentByID(int id);

	boolean updateStudent(int id, String studentname, String branch, String batch);

	boolean saveStudent(String studentname, String branch, String batch);

	

}
