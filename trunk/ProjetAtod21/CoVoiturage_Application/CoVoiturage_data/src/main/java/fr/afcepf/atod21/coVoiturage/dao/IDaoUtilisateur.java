package fr.afcepf.atod21.coVoiturage.dao;

import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;

public interface IDaoUtilisateur {

	void afficher();
	void changerPassword(Utilisateur utilisateur);
	Integer creerCompte(Utilisateur user);
	Utilisateur getUserById(Integer idUser);
}
