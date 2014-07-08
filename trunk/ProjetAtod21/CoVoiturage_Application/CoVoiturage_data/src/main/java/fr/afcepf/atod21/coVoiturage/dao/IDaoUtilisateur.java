package fr.afcepf.atod21.coVoiturage.dao;

import java.util.Date;
import java.util.List;

import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;

public interface IDaoUtilisateur {

	void afficher();

	Utilisateur seConnecter(String email, String password);

	void seDeconnecter(Utilisateur utilisateur);

	void changerPassword(Utilisateur utilisateur);

	Utilisateur creerCompte();

	void sInscrireTrajet(Integer idTrajet, Integer idUser);

	void seDesinscrireTrajet(Integer idTrajet, Integer idUser);

	void annulerInscriptionTrajet(Integer idTrajet, Integer idUser);

	List<Trajet> rechercherTrajet(Date dateDepart, String villeDepart,
			String villeArrivee, String statut);

	List<Trajet> rechercherTrajetParVilleDepart(Date dateDepart, String villeDepart, String statut);

	
}
