package com.iati.rapor;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.iati.rapor.service.IPgService;

public class AddRowController extends AbstractController {
	private IPgService pgService;
	private String pageName;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String email = request.getParameter("email");
		String departman = request.getParameter("departman");
		String rapor = request.getParameter("rapor");
		
		
		ModelAndView mview = new ModelAndView(getPageName());
		
		if(email != null && email.length() != 0 && departman != null && departman.length() != 0 && rapor != null && rapor.length() != 0) {
			pgService.addRow(email,departman,rapor);
			mview.getModel().put("result", "EKLENDI");
		} else {
			mview.getModel().put("result", "EKLENEMEDI");
			
		}
		
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
