package fr.afcepf.atod21.coVoiturage.managedBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.atod21.coVoiturage.business.IBusinessTrajet;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;
import fr.afcepf.atod21.coVoiturage.entity.Ville;

@ManagedBean
@SessionScoped
public class TrajetMBean {

	private Trajet trajet = new Trajet();
	private Utilisateur utilisateur;
	private Ville villeDepart = new Ville();
	private Ville villeArrivee = new Ville();
	
	private String date;
	
	

	@ManagedProperty (value="#{businessTrajetImpl}")
	private IBusinessTrajet businessTrajet;
	
	

	public void creerTrajet(){
		 
		 System.out.println("11111111111111111");
		 
		 villeDepart.setIdVille(1);
		 villeArrivee.setIdVille(2);
		 
		 System.out.println("Ville de depart ===> " + this.villeDepart);
		 
		 System.out.println(" Date initiale ===> " + date);
		 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			Date dateDepartConvert = new Date();
			try {
				dateDepartConvert = sdf.parse(date);
				
				System.out.println(" Date convertie ===> " + dateDepartConvert);

			} catch (ParseException e) {

				e.printStackTrace();
			}
		 
		 
			
		 Trajet trajetToInsert = new Trajet(dateDepartConvert, trajet.getNbPassagers(),"en cours",
				 trajet.getTarif(), villeDepart, villeArrivee);
			
			 
		 
		 
		 System.out.println("333333333333333333333"+trajetToInsert);
		   businessTrajet.creerTrajet(trajetToInsert);
		
		   ;
	 }
	 
	 public String supprimerTrajet(){
		 return "";
	 }
	 
	 public String ajouterCommentaireTrajet(){
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

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	
}
