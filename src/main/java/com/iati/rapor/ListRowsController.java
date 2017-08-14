package com.iati.rapor;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.iati.rapor.model.TestModel;
import com.iati.rapor.service.IPgService;

public class ListRowsController extends AbstractController {
	
	private IPgService pgService;
	private String pageName;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String email = request.getParameter("email");
		String departman = request.getParameter("departman");
		String raportarihTxt = request.getParameter("raportarih");
		Date raportarih = null;
		if(raportarihTxt != null && raportarihTxt.length() > 0) {
			raportarih=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("raportarih"));
		}
		//raportarih belirlemelisin sunumdaki kısıma parametre göndermek için
		
		if(email != null && email.length() == 0) {
			email = null;
		}
		if(departman != null && departman.length() == 0) {
			departman = null;
		}
		
		
		
		
		ModelAndView mview = new ModelAndView(getPageName());
		
		//if(raportarih != null) {
			List<TestModel> list = pgService.getRows(email,departman,raportarih);
			mview.getModel().put("list", list);
		//}
		
		return mview;
	}

	public IPgService getPgService() {
		return pgService;
	}

	public void setPgService(IPgService pgService) {
		this.pgService = pgService;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

}
