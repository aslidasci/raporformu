package com.iati.rapor.jdbc.proc;

import java.sql.Types;
import java.util.Date;
import java.util.List;

import com.iati.rapor.jdbc.BaseService;
import com.iati.rapor.jdbc.ProcedureDefinition;
import com.iati.rapor.jdbc.rowmapper.TestModelRowMapper;
import com.iati.rapor.model.TestModel;
import com.iati.rapor.service.IPgService;

public class PgService extends BaseService implements IPgService {
	
	private ProcedureDefinition procaddRow;
	private ProcedureDefinition procgetRows;
	private ProcedureDefinition prockullanicikayit;
	private ProcedureDefinition procgirisIslem;
	@Override
	public void afterPropertiesSet() throws Exception {
		
		procaddRow = new ProcedureDefinition(getSchemaName(), "add_row", false, Types.VARCHAR, Types.VARCHAR,Types.VARCHAR);
		procgetRows = new ProcedureDefinition(getSchemaName(), "get_rows", new TestModelRowMapper(), Types.VARCHAR,Types.VARCHAR,Types.DATE);
		prockullanicikayit = new ProcedureDefinition(getSchemaName(), "kullanici_kayit", false, Types.VARCHAR, Types.VARCHAR);
		procgirisIslem = new ProcedureDefinition(getSchemaName(), "giris_islem", Types.INTEGER, Types.VARCHAR, Types.VARCHAR);
	}
	
	@Override
	public void kullanicikayit(String kadi,String sifre) {
		executeProcedureNoReturn(prockullanicikayit, kadi,sifre);
	}

	@Override
	public void addRow(String email,String departman,String rapor) {
		executeProcedureNoReturn(procaddRow, email,departman,rapor);
	}

	@Override
	public List<TestModel> getRows(String email,String departman,Date raportarih) {
		List<TestModel> list = executeProcedure(procgetRows, email,departman,raportarih);
		return list;
	}
	
	@Override
	public int girisIslem(String kadi,String sifre) {
		return executeProcedureInt(procgirisIslem, kadi,sifre);
	}

}

