package fr.afcepf.atod21.coVoiturage.managedBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.atod21.coVoiturage.business.IBusinessUtilisateur;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;

@ManagedBean
@SessionScoped
public class UtilisateurMBean {

	@ManagedProperty(value = "#{businessUtilisateurImpl}")
	private IBusinessUtilisateur businessUtilisateur;

	private String email;
	private String password;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private Utilisateur user;
	private Trajet trajet;

	@PostConstruct
	public void init() {
		System.out.println("Initialisation du bean 'UtilisateurMBean'");
	}

	public String valider() {
		System.out.println("-- dans UtilisateurMBeab.valider()");
		this.businessUtilisateur.afficher();
		return "afficher ok";
	}

	public String seConnecter() {
		return "";
	}

	public String creerCompte() {
		return "";
	}

	public String seDeconnecter() {
		return "";
	}

	public String changerPassword() {
		return "";
	}

	public String motdepasseOublie() {
		return "";
	}

	public String sInscireTrajet() {
		return "";
	}

	public String seDesincrireTrajet() {
		return "";
	}

	public String annulerInscriptionTrajet() {
		return "";
	}

	public String rechercherTrajet() {
		return "";
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public Trajet getTrajet() {
		return trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

	public IBusinessUtilisateur getBusinessUtilisateur() {
		return businessUtilisateur;
	}

	public void setBusinessUtilisateur(IBusinessUtilisateur businessUtilisateur) {
		this.businessUtilisateur = businessUtilisateur;
	}

}
