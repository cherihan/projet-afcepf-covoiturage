package fr.afcepf.atod21.cov.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xml.sax.SAXException;

import fr.afcepf.atod21.cov.action.ActionCov;
import fr.afcepf.atod21.cov.action.ActionCovForm;
import fr.afcepf.atod21.cov.bean.BeanCovPopulate;
import fr.afcepf.atod21.cov.factory.Factory;

public class ActionCovServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String forwardPath = null;
			Factory factory = new Factory().getInstance();
			ActionCov action = factory.getAction(request.getRequestURI());
			ActionCovForm actionForm = factory.getActionForm(request.getParameter("form"));
			BeanCovPopulate beanToPopulate = new BeanCovPopulate();
			beanToPopulate.populateBean(actionForm, request.getParameterMap());
			forwardPath = action.execute(request, response);
			if(forwardPath == null){
				forwardPath = request.getRequestURI();
			}
			RequestDispatcher reqDispatch = request.getRequestDispatcher(forwardPath);
			reqDispatch.forward(request, response);
					
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
