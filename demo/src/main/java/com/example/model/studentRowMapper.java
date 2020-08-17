package com.example.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class studentRowMapper implements RowMapper<StudentDataModel> {

	@Override
	public StudentDataModel mapRow(ResultSet row, int rowNum) throws SQLException {
		StudentDataModel studentDataModel = new StudentDataModel();
		studentDataModel.setID(row.getInt("ID"));
		studentDataModel.setSTUDENTNAME(row.getString("STUDENTNAME"));
		studentDataModel.setBATCH(row.getString("BATCH"));
		studentDataModel.setBRANCH(row.getString("BRANCH"));
		return studentDataModel;
	}

}
