package fr.afcepf.atod21.cov.action;

import javax.servlet.ServletRequest;

import fr.afcepf.atod21.cov.errors.ActionCovErrors;
import fr.afcepf.atod21.cov.mapping.ActionCovMapping;

public interface IActionCovForm {
	ActionCovErrors validate(ActionCovMapping mapping, ServletRequest request);
}
