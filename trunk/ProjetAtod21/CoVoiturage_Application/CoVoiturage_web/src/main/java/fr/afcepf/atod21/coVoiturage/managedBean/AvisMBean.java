package fr.afcepf.atod21.coVoiturage.managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.atod21.coVoiturage.business.IBusinessAvis;
import fr.afcepf.atod21.coVoiturage.entity.Avis;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;

@ManagedBean
@SessionScoped
public class AvisMBean {
	
	private Avis avis;
	private Trajet trajet;
	
	@ManagedProperty (value="#{businessAvisImpl}")
	private IBusinessAvis businessAvis;

	public IBusinessAvis getBusinessAvis() {
		return businessAvis;
	}

	public void setBusinessAvis(IBusinessAvis businessAvis) {
		this.businessAvis = businessAvis;
	}

	public Avis getAvis() {
		return avis;
	}

	public void setAvis(Avis avis) {
		this.avis = avis;
	}

	public Trajet getTrajet() {
		return trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

	
}
