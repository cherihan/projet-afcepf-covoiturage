package fr.afcepf.atod21.coVoiturage.business;

import java.util.Date;
import java.util.List;

import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;

public interface IBusinessUtilisateur {

	void afficher();
	Utilisateur seConnecter(String email, String password);
	void seDeconnecter(Utilisateur utilisateur);
	void changerPassword(Utilisateur utilisateur);
	Integer creerCompte(Utilisateur user);
	void sInscrireTrajet(Trajet trajet, Utilisateur user);
	void seDesinscrireTrajet(Integer idTrajet, Integer idUser);
	void annulerInscriptionTrajet(Integer idTrajet, Integer idUser);
	List<Trajet> rechercherTrajet(Date dateDepart, String villeDepart, String villeArrivee, String statut);
	List<Trajet> rechercherTrajetParVilleDepart(Date dateDepart, String villeDepart, String statut);
	Utilisateur getUserById(Integer idUser);
}
