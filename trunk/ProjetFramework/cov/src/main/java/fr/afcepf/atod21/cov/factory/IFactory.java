package fr.afcepf.atod21.cov.factory;

import org.w3c.dom.DOMException;

import fr.afcepf.atod21.cov.action.ActionCov;
import fr.afcepf.atod21.cov.action.ActionCovForm;

public interface IFactory {
	ActionCov getAction(String uri) throws InstantiationException, IllegalAccessException, ClassNotFoundException;
	ActionCovForm getActionForm(String tagName) throws InstantiationException, IllegalAccessException, ClassNotFoundException, DOMException;
}
