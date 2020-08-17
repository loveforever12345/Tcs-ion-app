package com.example.Services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dao.IStudentDataDao;
import com.example.model.StudentDataModel;


@Service
public class StudentDataService implements IStudentDataService {
	private static final Logger logger = LogManager.getLogger(StudentDataService.class);

	@Autowired
	private IStudentDataDao studentDataDAO;

		@Override
	public List<StudentDataModel> getAllstudentData(){
		logger.info("Fetching all Student Data");
		return studentDataDAO.getAllstudentData();
	}
		@Override
		public boolean saveStudent(String studentname, String branch, String batch) {
			logger.info("Saving all Student Data");
			return studentDataDAO.saveStudent(studentname,branch,batch);
		}

		@Override
		public boolean deleteStudent(int id) {
			logger.info("Deleting all Student Data with id");
			return studentDataDAO.deleteStudent(id);
		}

		@Override
		public List<StudentDataModel> getStudentByID(int id) {
			logger.info("Fetching all Student Data with id");
			return studentDataDAO.getStudentByID(id);
		}

		@Override
		public boolean updateStudent(int id, String studentname, String branch, String batch) {
			logger.info("Updating all Student Data with id");
			return studentDataDAO.updateStudent(id,studentname,branch,batch);
		}
	
}
