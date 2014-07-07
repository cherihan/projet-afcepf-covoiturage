package fr.afcepf.atod21.coVoiturage.managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.atod21.coVoiturage.business.IBusinessTrajet;

@ManagedBean
@SessionScoped
public class TrajetMBean {

	@ManagedProperty (value="#{businessTrajetImpl}")
	private IBusinessTrajet businessTrajet;

	public IBusinessTrajet getBusinessTrajet() {
		return businessTrajet;
	}

	public void setBusinessTrajet(IBusinessTrajet businessTrajet) {
		this.businessTrajet = businessTrajet;
	}
	
	
}
