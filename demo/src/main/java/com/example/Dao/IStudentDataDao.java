package com.example.Dao;

import java.util.List;

import com.example.model.StudentDataModel;

public interface IStudentDataDao {
    List<StudentDataModel> getAllstudentData();


	boolean deleteStudent(int id);

	List<StudentDataModel> getStudentByID(int id);

	boolean updateStudent(int id, String studentname, String branch, String batch);

	boolean saveStudent(String studentname, String branch, String batch);
}
