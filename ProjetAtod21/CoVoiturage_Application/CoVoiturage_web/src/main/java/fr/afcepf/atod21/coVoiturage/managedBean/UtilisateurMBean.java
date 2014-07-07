package fr.afcepf.atod21.coVoiturage.managedBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.atod21.coVoiturage.business.IBusinessUtilisateur;

@ManagedBean
@SessionScoped
public class UtilisateurMBean {

	@ManagedProperty (value="#{businessUtilisateurImpl}")
	private IBusinessUtilisateur businessUtilisateur;

	@PostConstruct
	public void init() {
		System.out.println("Initialisation du bean 'UtilisateurMBean'");
	}
	
	public String valider() {
		System.out.println("-- dans UtilisateurMBeab.valider()");
		this.businessUtilisateur.afficher();
		return "afficher ok";
	}
	
	public IBusinessUtilisateur getBusinessUtilisateur() {
		return businessUtilisateur;
	}

	public void setBusinessUtilisateur(IBusinessUtilisateur businessUtilisateur) {
		this.businessUtilisateur = businessUtilisateur;
	}
	
	
}
