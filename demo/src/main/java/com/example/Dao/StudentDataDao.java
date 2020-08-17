package com.example.Dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.StudentDataModel;
import com.example.model.studentRowMapper;
@Transactional
@Repository
public class StudentDataDao implements IStudentDataDao {
	private static final Logger logger = LogManager.getLogger(StudentDataDao.class);

	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Value("${sql.getStudentData}")
    private String getStudentData;
	@Value("${sql.addStudentdata}")
    private String addStudentdata;
	@Value("${sql.deleteStudentData}")
    private String deleteStudentdata;
	@Value("${sql.getByIdStudentdata}")
    private String getByIdStudentdata;
	@Value("${sql.updateByIdStudentdata}")
    private String updateByIdStudentdata;
	@Override
	public List<StudentDataModel> getAllstudentData() {
   		RowMapper<StudentDataModel> rowMapper = new studentRowMapper();
		return this.jdbcTemplate.query(getStudentData, rowMapper);
	}	
	@Override
	public boolean saveStudent(String studentname, String branch, String batch) {
		boolean status=false;
		try {
			jdbcTemplate.update(addStudentdata, new Object[] { studentname,branch,batch});
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}


	@Override
	public boolean deleteStudent(int id) {
		boolean status=false;
		try {
			jdbcTemplate.update(deleteStudentdata, new Object[] {id});
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<StudentDataModel> getStudentByID(int id) {
		RowMapper<StudentDataModel> rowMapper = new studentRowMapper();
		return this.jdbcTemplate.query(getByIdStudentdata, rowMapper, new Object[] { id });
	}

	@Override
	public boolean updateStudent(int id, String studentname, String branch, String batch) {
		boolean status=false;
		try {
			jdbcTemplate.update(updateByIdStudentdata, new Object[] { studentname,batch,branch,id});
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
