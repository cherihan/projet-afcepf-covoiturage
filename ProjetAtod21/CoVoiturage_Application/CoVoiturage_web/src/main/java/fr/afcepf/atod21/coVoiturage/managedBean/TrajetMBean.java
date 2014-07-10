package fr.afcepf.atod21.coVoiturage.managedBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.afcepf.atod21.coVoiturage.business.IBusinessTrajet;
import fr.afcepf.atod21.coVoiturage.business.IBusinessUtilisateur;
import fr.afcepf.atod21.coVoiturage.common.Common;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;
import fr.afcepf.atod21.coVoiturage.entity.Ville;

@ManagedBean
@SessionScoped
public class TrajetMBean {

	private Trajet trajet = new Trajet();

	private String dateDepart;
	private String nbPassagersSelected;

	private Ville villeDepart = new Ville();
	private Ville villeArrivee = new Ville();

	private List<Ville> listVilles = new ArrayList<Ville>();
	private List<String> listNomVilles = new ArrayList<String>();

	private Map<String, Ville> mapVilles = new HashMap<String, Ville>();

	@ManagedProperty(value = "#{businessTrajetImpl}")
	private IBusinessTrajet businessTrajet;

	@ManagedProperty(value = "#{businessUtilisateurImpl}")
	private IBusinessUtilisateur businessUtilisateur;

	@PostConstruct
	public void init() {

		this.listVilles = businessTrajet.getAllVilles();

		for (Ville v : this.listVilles) {

			mapVilles.put(v.getNom(), v);
			this.listNomVilles.add(v.getNom());

		}

		System.out.println(" ---------------- init trajet bean ---------------------------");
	

	}

	public String creerTrajet(Utilisateur userEnSession) {

		String redirection = "success";

		this.villeDepart = this.mapVilles.get(this.villeDepart.getNom());

		this.villeArrivee = this.mapVilles.get(this.villeArrivee.getNom());

		Date dateDepart = Common.convertDate(this.dateDepart);

		int nbPassagers = Integer.parseInt(this.nbPassagersSelected);

		Trajet trajetToInsert = new Trajet(dateDepart, nbPassagers, "en cours",
				trajet.getTarif(), villeDepart, villeArrivee);

		Integer idTrajet = businessTrajet.creerTrajet(trajetToInsert,
				userEnSession);

		FacesMessage message = new FacesMessage(
				"Votre trajet a été crée avec succès !");
		FacesContext.getCurrentInstance().addMessage(null, message);

		if (idTrajet == null) {

			redirection = "error";
		}

		clearFormUtilisateur();

		return redirection;

	}

	public String annuler() {

		clearFormUtilisateur();


		return "cancel";
	}

	private void clearFormUtilisateur() {
		HttpSession session = ((HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest())
				.getSession();
		UtilisateurMBean utilisateurBean = (UtilisateurMBean) session
				.getAttribute("utilisateurMBean");

		utilisateurBean.setDateDepart("");
		utilisateurBean.setVilleDepart(null);
		utilisateurBean.setVilleArrivee(null);

	}



	public String supprimerTrajet() {
		return "";
	}

	public String ajouterCommentaireTrajet() {
		return "";
	}

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

	public String getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}

	public String getNbPassagersSelected() {
		return nbPassagersSelected;
	}

	public void setNbPassagersSelected(String nbPassagersSelected) {
		this.nbPassagersSelected = nbPassagersSelected;
	}

	public List<Ville> getListVilles() {
		return listVilles;
	}

	public void setListVilles(List<Ville> listVilles) {
		this.listVilles = listVilles;
	}

	public Map<String, Ville> getMapVilles() {
		return mapVilles;
	}

	public void setMapVilles(Map<String, Ville> mapVilles) {
		this.mapVilles = mapVilles;
	}

	public Ville getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(Ville villeDepart) {
		this.villeDepart = villeDepart;
	}

	public Ville getVilleArrivee() {
		return villeArrivee;
	}

	public void setVilleArrivee(Ville villeArrivee) {
		this.villeArrivee = villeArrivee;
	}

	public List<String> getListNomVilles() {
		return listNomVilles;
	}

	public void setListNomVilles(List<String> listNomVilles) {
		this.listNomVilles = listNomVilles;
	}

	public IBusinessUtilisateur getBusinessUtilisateur() {
		return businessUtilisateur;
	}

	public void setBusinessUtilisateur(IBusinessUtilisateur businessUtilisateur) {
		this.businessUtilisateur = businessUtilisateur;
	}

}
