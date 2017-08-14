package com.iati.rapor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.iati.rapor.service.IPgService;

public class LoginController extends AbstractController {
	
	private IPgService pgService;
	private String pageName;

	
   @Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mview = new ModelAndView(getPageName());
		
		String kadi = request.getParameter("kadi");
		String sifre = request.getParameter("sifre");
		
		if(kadi == null && sifre == null) {
			return mview;
		}
		
		int result = pgService.girisIslem(kadi, sifre);
		if(result > 0) {
			//mview.getModel().put("result", "giriş başarılı");
			request.getSession().setAttribute("LOGGEDIN_USER",kadi);
			mview.setViewName("secim");
			return mview;
		} else {
			mview.getModel().put("result", "kullanici adi veya sifre hatali");
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
