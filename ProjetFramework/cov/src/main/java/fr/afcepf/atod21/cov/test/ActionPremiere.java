package fr.afcepf.atod21.cov.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.afcepf.atod21.cov.action.ActionCov;

public class ActionPremiere extends ActionCov{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		FormAjouterPersonne formPersonne = new FormAjouterPersonne();
		return "";
	}
	
}
