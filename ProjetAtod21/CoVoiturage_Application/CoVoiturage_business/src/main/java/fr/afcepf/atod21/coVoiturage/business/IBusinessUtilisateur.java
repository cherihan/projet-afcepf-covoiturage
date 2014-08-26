package fr.afcepf.atod21.coVoiturage.business;

import java.util.Date;
import java.util.List;

import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;

public interface IBusinessUtilisateur {

	void afficher();
	void changerPassword(Utilisateur utilisateur);
	Integer creerCompte(Utilisateur user);
	Utilisateur getUserById(Integer idUser);
}
