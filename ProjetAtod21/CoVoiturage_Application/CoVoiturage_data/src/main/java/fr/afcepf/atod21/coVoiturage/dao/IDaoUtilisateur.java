package fr.afcepf.atod21.coVoiturage.dao;

import java.util.Date;

import fr.afcepf.atod21.coVoiturage.entity.Trajet;

public interface IDaoUtilisateur {

	void afficher();
	
	void sInscrireTrajet(Integer idTrajet, Integer idUser);
	void seDesinscrireTrajet(Integer idTrajet, Integer idUser);
	void annulerInscriptionTrajet(Integer idTrajet, Integer idUser);
	Trajet rechercherTrajet(Date date, String villeDepart, String villeArrivee);
}
