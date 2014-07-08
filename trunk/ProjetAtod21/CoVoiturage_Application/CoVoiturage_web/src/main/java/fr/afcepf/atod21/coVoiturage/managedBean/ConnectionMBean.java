package fr.afcepf.atod21.coVoiturage.managedBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.atod21.coVoiturage.business.IBusinessUtilisateur;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;

@ManagedBean
@SessionScoped
public class ConnectionMBean {

	@ManagedProperty(value = "#{businessUtilisateurImpl}")
	private IBusinessUtilisateur businessUtilisateur;

	private String email;
	private String password;
	private Utilisateur user;

	private boolean userConnected = false;
	private boolean userExists = true;
	private boolean userRemembered = false;

	@PostConstruct
	public void init() {
	}

	public String seConnecter() {
		this.user = this.businessUtilisateur.seConnecter(email, password);
		if (this.user != null) {
			this.userConnected = true;
		}
		else {
			this.userExists = false;
			System.out.println("--> Utilisateur non trouvé !");
		}
		return "";
	}

	public String seDeconnecter() {
		this.businessUtilisateur.seDeconnecter(user);
		this.user = null;
		this.userConnected=false;
		this.userExists = true;
		if (!userRemembered)
			this.email="";
		return "";
	}

	public String changerPassword() {
		//TODO
		return "";
	}

	public String creerCompte() {
		//TODO
		return "";
	}

	
	public IBusinessUtilisateur getBusinessUtilisateur() {
		return businessUtilisateur;
	}

	public void setBusinessUtilisateur(IBusinessUtilisateur businessUtilisateur) {
		this.businessUtilisateur = businessUtilisateur;
	}

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

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur utilisateur) {
		this.user = utilisateur;
	}
	
	public boolean isUserConnected() {
		return userConnected;
	}

	public void setUserConnected(boolean userConnected) {
		this.userConnected = userConnected;
	}

	public boolean isUserRemembered() {
		return userRemembered;
	}

	public void setUserRemembered(boolean userRemember) {
		this.userRemembered = userRemember;
	}

	public boolean isUserExists() {
		return userExists;
	}

	public void setUserExists(boolean userExists) {
		this.userExists = userExists;
	}

}
