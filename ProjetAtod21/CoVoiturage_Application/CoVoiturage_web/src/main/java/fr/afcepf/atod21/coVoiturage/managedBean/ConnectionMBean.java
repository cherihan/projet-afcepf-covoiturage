package fr.afcepf.atod21.coVoiturage.managedBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.atod21.coVoiturage.business.IBusinessConnexion;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;

@ManagedBean
@SessionScoped
public class ConnectionMBean {

	@ManagedProperty(value = "#{businessConnexionImpl}")
	private IBusinessConnexion businessConnexion;

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

		this.user = this.businessConnexion.seConnecter(email, password);
		if (this.user != null)
			this.userConnected = true;
		else
			this.userExists = false;
		return "";
	}

	public String seDeconnecter() {
		this.businessConnexion.seDeconnecter(user);
		this.user = null;
		this.userConnected=false;
		this.userExists = true;
		if (!userRemembered)
			this.email="";
		return "index.xhtml";
	}

	public String changerPassword() {
		//TODO
		return "";
	}

	public String creerCompte() {
		//TODO
		return "";
	}

	

	/**
     * @return the businessConnexion
     */
    public IBusinessConnexion getBusinessConnexion() {
        return businessConnexion;
    }

    /**
     * @param paramBusinessConnexion the businessConnexion to set
     */
    public void setBusinessConnexion(IBusinessConnexion paramBusinessConnexion) {
        businessConnexion = paramBusinessConnexion;
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
