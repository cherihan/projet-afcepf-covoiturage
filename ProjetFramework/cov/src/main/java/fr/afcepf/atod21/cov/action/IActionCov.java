package fr.afcepf.atod21.cov.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IActionCov {
	String execute(HttpServletRequest request, HttpServletResponse response);
}
