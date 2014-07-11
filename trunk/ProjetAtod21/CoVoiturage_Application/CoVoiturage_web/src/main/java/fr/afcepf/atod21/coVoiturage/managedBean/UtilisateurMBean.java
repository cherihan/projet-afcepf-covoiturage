package fr.afcepf.atod21.coVoiturage.managedBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.afcepf.atod21.coVoiturage.business.IBusinessUtilisateur;
import fr.afcepf.atod21.coVoiturage.common.Common;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;

@ManagedBean
@SessionScoped
public class UtilisateurMBean {

	@ManagedProperty(value = "#{businessUtilisateurImpl}")
	private IBusinessUtilisateur businessUtilisateur;

	private Utilisateur user;
	private Trajet trajet;

	private String email;
	private String password;
	private String villeDepart;
	private String villeArrivee;
	private String dateDepart;
	private boolean displayTableResultsTrajets = false;
	private HtmlDataTable dataTableTrajets = new HtmlDataTable();

	private List<Trajet> listResults = new ArrayList<Trajet>();

	@PostConstruct
	public void init() {

	}

	public String sInscireTrajet(Trajet trajet, Utilisateur user) {

		try {
			businessUtilisateur.sInscrireTrajet(trajet, user);
			FacesMessage message = new FacesMessage(
					"Votre demande d'inscription à ce trajet est enregistrée !");
			FacesContext.getCurrentInstance().addMessage(null, message);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

	public String seDesincrireTrajet() {
		// TODO
		return "";
	}

	public String annulerInscriptionTrajet() {
		// TODO
		return "";
	}

	public String rechercherTrajet() {

		String statut = "en cours";
		String retour = "listerTrajets";

		Date dateToConvert = Common.convertDate(this.dateDepart);

		if (this.villeArrivee == null || this.villeArrivee.trim().length() == 0) {

			this.listResults = this.businessUtilisateur
					.rechercherTrajetParVilleDepart(dateToConvert, villeDepart,
							statut);

		} else {

			this.listResults = this.businessUtilisateur.rechercherTrajet(
					dateToConvert, this.villeDepart, this.villeArrivee, statut);

		}

		if (listResults != null) {
			this.displayTableResultsTrajets = true;

		}
		if (listResults.size() == 0 || listResults == null) {
			FacesMessage message = new FacesMessage(
					"Aucun resultat disponible !");
			FacesContext.getCurrentInstance().addMessage(null, message);
			this.displayTableResultsTrajets = false;
			retour = "error";
		}

		return retour;

	}

	public String motDepasseOublie() {
		// TODO
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

	public String getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}

	public String getVilleArrivee() {
		return villeArrivee;
	}

	public void setVilleArrivee(String villeArrivee) {
		this.villeArrivee = villeArrivee;
	}

	public String getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}

	public boolean isDisplayTableResultsTrajets() {
		return displayTableResultsTrajets;
	}

	public void setDisplayTableResultsTrajets(boolean displayTableResultsTrajets) {
		this.displayTableResultsTrajets = displayTableResultsTrajets;
	}

	public List<Trajet> getListResults() {
		return listResults;
	}

	public void setListResults(List<Trajet> listResults) {
		this.listResults = listResults;
	}

	public HtmlDataTable getDataTableTrajets() {
		return dataTableTrajets;
	}

	public void setDataTableTrajets(HtmlDataTable dataTableTrajets) {
		this.dataTableTrajets = dataTableTrajets;
	}
}
