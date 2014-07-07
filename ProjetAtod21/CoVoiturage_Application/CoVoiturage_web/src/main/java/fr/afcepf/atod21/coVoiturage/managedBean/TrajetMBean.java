package fr.afcepf.atod21.coVoiturage.managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.atod21.coVoiturage.business.IBusinessTrajet;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;

@ManagedBean
@SessionScoped
public class TrajetMBean {

	private Trajet trajet;
	private Utilisateur utilisateur;
	
	@ManagedProperty (value="#{businessTrajetImpl}")
	private IBusinessTrajet businessTrajet;

	public IBusinessTrajet getBusinessTrajet() {
		return businessTrajet;
	}

	public void setBusinessTrajet(IBusinessTrajet businessTrajet) {
		this.businessTrajet = businessTrajet;
	}

	public Trajet getTrajet() {
		return trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
}
