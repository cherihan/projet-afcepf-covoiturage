package fr.afcepf.atod21.cov.test;

import fr.afcepf.atod21.cov.action.ActionCovForm;

public class FormAjouterPersonne extends ActionCovForm {
	
	private String nom;
	private String prenom;
	private String dateNaissance;
	
	public FormAjouterPersonne() {
		super();
	}
	
	public FormAjouterPersonne(String nom, String prenom, String dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
}
