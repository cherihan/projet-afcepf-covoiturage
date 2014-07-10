package fr.afcepf.atod21.coVoiturage.managedBean;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import fr.afcepf.atod21.coVoiturage.business.IBusinessUtilisateur;
import fr.afcepf.atod21.coVoiturage.common.Common;
import fr.afcepf.atod21.coVoiturage.entity.Adresse;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;
import fr.afcepf.atod21.coVoiturage.entity.Ville;

@ManagedBean
@SessionScoped
public class InscriptionMBean {

	@ManagedProperty(value = "#{businessUtilisateurImpl}")
	private IBusinessUtilisateur businessUtilisateur;

	private Utilisateur user = new Utilisateur();
	private Integer idUser;
	private String dateNaissanceSaisie;
	private String confirmationPassword;
	private Adresse userAdress = new Adresse();
	private Ville userCity = new Ville();
	private String messageErrorPassword;
	@PostConstruct
	public void init() {
	}

	
	public String creerCompte() {
		String retour = "success";
		messageErrorPassword = "";
		if (user.getPassword().equals(confirmationPassword))
		{
			try
			{
				userAdress.setVille(userCity);
				user.setAdresse(userAdress);
				Date userNaissance = Common.convertDate(dateNaissanceSaisie);
				user.setDateNaissance(userNaissance);
				idUser = businessUtilisateur.creerCompte(user);
			}
			
			catch (Exception e) {
				e.printStackTrace();
				retour = "error";
			}	
		}
		else
		{
			messageErrorPassword = "Attention, les deux passwords que vous avez saisis ne sont pas identiques !";
			retour = "error";
		}
		System.out.println(retour);
		return retour;
	}

	
	public IBusinessUtilisateur getBusinessUtilisateur() {
		return businessUtilisateur;
	}
	public void setBusinessUtilisateur(IBusinessUtilisateur businessUtilisateur) {
		this.businessUtilisateur = businessUtilisateur;
	}

	public Utilisateur getUser() {
		return user;
	}
	public void setUser(Utilisateur utilisateur) {
		this.user = utilisateur;
	}

	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getDateNaissanceSaisie() {
		return dateNaissanceSaisie;
	}
	public void setDateNaissanceSaisie(String dateNaissanceSaisie) {
		this.dateNaissanceSaisie = dateNaissanceSaisie;
	}


	public String getConfirmationPassword() {
		return confirmationPassword;
	}
	public void setConfirmationPassword(String confirmationPassword) {
		this.confirmationPassword = confirmationPassword;
	}
	
	
	public String getMessageErrorPassword() {
		return messageErrorPassword;
	}
	public void setMessageErrorPassword(String messageErrorPassword) {
		this.messageErrorPassword = messageErrorPassword;
	}


	public Adresse getUserAdress() {
		return userAdress;
	}
	public void setUserAdress(Adresse userAdress) {
		this.userAdress = userAdress;
	}


	public Ville getUserCity() {
		return userCity;
	}
	public void setUserCity(Ville userCity) {
		this.userCity = userCity;
	}
}