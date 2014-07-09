package fr.afcepf.atod21.coVoiturage.managedBean;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.criteria.CriteriaBuilder.In;

import fr.afcepf.atod21.coVoiturage.business.IBusinessTrajet;
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

	@PostConstruct
	public void init() {

		System.out.println("---------- init Trajet Bean -------------");

		this.listVilles = businessTrajet.getAllVilles();

		for (Ville v : this.listVilles) {

			System.out.println("Ville ===> " + v.getNom());

			mapVilles.put(v.getNom(), v);
			this.listNomVilles.add(v.getNom());

		}

	}

	public String creerTrajet() {
		this.villeDepart = this.mapVilles.get(this.villeDepart.getNom());

		this.villeArrivee = this.mapVilles.get(this.villeArrivee.getNom());

		System.out.println("------ date selected ----- " + this.dateDepart);




		 Date dateDepart = Common.convertDate(this.dateDepart);
		

		

		System.out.println("------ date selected after conversion ----- "
				+ dateDepart);

		int nbPassagers = Integer.parseInt(this.nbPassagersSelected);

		Trajet trajetToInsert = new Trajet(dateDepart, nbPassagers, "en cours",
				trajet.getTarif(), villeDepart, villeArrivee);

		List<Utilisateur> listUsers = new ArrayList<>();


		trajetToInsert.setUtilisateurs(listUsers);

		// this.trajet.setVilleDepart(villeDepart);
		// this.trajet.setVilleArrivee(villeArrivee);
		// this.trajet.setDateDepart(dateDepart);

		// this.trajet.setStatut("en cours");

		businessTrajet.creerTrajet(trajetToInsert);

		return "";

	}

	public String annuler() {
		return "";
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

}
