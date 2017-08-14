package com.iati.rapor.jdbc.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.iati.rapor.model.TestModel;

public class TestModelRowMapper implements RowMapper<TestModel> {

	@Override
	public TestModel mapRow(ResultSet rset, int rowNo) throws SQLException {
		TestModel model = new TestModel();
		model.setEmail(rset.getString(1));
		model.setDepartman(rset.getString(2));
		model.setRapor(rset.getString(3));
		model.setRaportarih(rset.getTimestamp(4));
		
		return model;
	}


}
