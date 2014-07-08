package fr.afcepf.atod21.coVoiturage.dao;

import java.util.Date;

import fr.afcepf.atod21.coVoiturage.entity.Trajet;

public interface IDaoTrajet {

	void ajouterCommentaireTrajet(int idTrajet, int idUser);
	//Trajet creerTrajet(int idUser, String villeDepart, String villeArrivee, Date date, int tarif, int nbPassagers);
	void creerTrajet(Trajet trajet);
	void supprimerTrajet(int idTrajet, int idUser);
}
