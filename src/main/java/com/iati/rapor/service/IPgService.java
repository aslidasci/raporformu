package com.iati.rapor.service;

import java.util.Date;
import java.util.List;

import com.iati.rapor.model.TestModel;

public interface IPgService {

	void kullanicikayit(String kadi,String sifre);
	
	void addRow(String email,String departman,String rapor);
	
	List<TestModel> getRows(String email,String departman,Date raportarih);
	
	int girisIslem(String kadi,String sifre);
	
	

}
