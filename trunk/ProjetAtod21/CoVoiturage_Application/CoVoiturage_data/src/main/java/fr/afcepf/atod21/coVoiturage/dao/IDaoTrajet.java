package fr.afcepf.atod21.coVoiturage.dao;

import java.util.List;

import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;
import fr.afcepf.atod21.coVoiturage.entity.Ville;

public interface IDaoTrajet {

	void ajouterCommentaireTrajet(int idTrajet, int idUser);
	//Trajet creerTrajet(int idUser, String villeDepart, String villeArrivee, Date date, int tarif, int nbPassagers);
	Integer creerTrajet(Trajet trajet, Utilisateur user);
	void supprimerTrajet(int idTrajet, int idUser);
	List<Ville> getAllVilles();
	List<Trajet> getTrajetsEnCoursById(int idUser);
	List<Trajet> getTrajetsEffectuesById(int idUser);
	List<Trajet> getTrajetsProposesById(int idUser);
	
}