package fr.afcepf.atod21.cov.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ActionCov implements IActionCov {

	@Override
	public abstract String execute(HttpServletRequest request, HttpServletResponse response);

}
