package com.iati.rapor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.iati.rapor.service.IPgService;

	public class SecimController extends AbstractController {
		private IPgService pgService;
		private String pageName;

		@Override
		protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			
			
			ModelAndView mview = new ModelAndView(getPageName());
			
			
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
