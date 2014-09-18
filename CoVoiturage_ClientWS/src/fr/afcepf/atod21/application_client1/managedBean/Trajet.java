package fr.afcepf.atod21.application_client1.managedBean;

import java.util.List;

public class Trajet {
	private String villeDepart;
	private String villeArrivee;
	private int prix;
	private int nbre_de_place;
	private String dateDepart;

	
	
	
	public String getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}
	public Trajet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Trajet(String villeDepart, String villeArrivee, int prix,
			int nbre_de_place, List<Trajet> listeDeTrajet) {
		super();
		this.villeDepart = villeDepart;
		this.villeArrivee = villeArrivee;
		this.prix = prix;
		this.nbre_de_place = nbre_de_place;
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
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public int getNbre_de_place() {
		return nbre_de_place;
	}
	public void setNbre_de_place(int nbre_de_place) {
		this.nbre_de_place = nbre_de_place;
	}
	@Override
	public String toString() {
		return "Trajet [villeDepart=" + villeDepart + ", villeArrivee="
				+ villeArrivee + ", prix=" + prix + ", nbre_de_place="
				+ nbre_de_place + ", dateDepart=" + dateDepart + "]";
	}

	
	
	
	

}
