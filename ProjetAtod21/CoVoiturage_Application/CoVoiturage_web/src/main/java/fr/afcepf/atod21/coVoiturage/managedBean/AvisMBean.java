package fr.afcepf.atod21.coVoiturage.managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.atod21.coVoiturage.business.IBusinessAvis;

@ManagedBean
@SessionScoped
public class AvisMBean {
	
	@ManagedProperty (value="#{businessAvisImpl}")
	private IBusinessAvis businessAvis;

	public IBusinessAvis getBusinessAvis() {
		return businessAvis;
	}

	public void setBusinessAvis(IBusinessAvis businessAvis) {
		this.businessAvis = businessAvis;
	}

	
}
