package com.iati.rapor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.iati.rapor.service.IPgService;

public class KullaniciKayitController extends AbstractController {
	
	private IPgService pgService;
	private String pageName;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String kadi = request.getParameter("kadi");
		String sifre = request.getParameter("sifre");

		request.getSession().setAttribute("LOGGEDIN_USER",null);
		
		ModelAndView mview = new ModelAndView(getPageName());
		
		if(kadi != null && sifre != null) {
			pgService.kullanicikayit(kadi,sifre);
			mview.getModel().put("result", "BASARILI");
		} else {
			mview.getModel().put("result", "BASARISIZ");
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
