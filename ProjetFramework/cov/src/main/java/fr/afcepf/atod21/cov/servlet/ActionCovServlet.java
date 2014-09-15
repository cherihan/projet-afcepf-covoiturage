package fr.afcepf.atod21.cov.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class ActionCovServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected String config = "/WEB-INF/cov-config.xml";

	/**
     * <p>Initialize this servlet.  Most of the processing has been factored into
     * support methods so that you can override particular functionality at a
     * fairly granular level.</p>
     *
     * @exception ServletException if we cannot configure ourselves correctly
     */
    public void init() throws ServletException {
    	System.out.println("toto");
    }



}
