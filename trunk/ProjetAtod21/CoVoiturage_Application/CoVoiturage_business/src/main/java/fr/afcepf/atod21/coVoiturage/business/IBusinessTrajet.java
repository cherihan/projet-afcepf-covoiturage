package fr.afcepf.atod21.coVoiturage.business;

import java.util.List;

import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;
import fr.afcepf.atod21.coVoiturage.entity.Ville;

public interface IBusinessTrajet {

	void ajouterCommentaireTrajet(int idTrajet, int idUser);
	Integer creerTrajet(Trajet trajet, Utilisateur user);
	void supprimerTrajet(int idTrajet, int idUser);
	List<Ville> getAllVilles();
	List<Trajet> getHistoTrajets(int idUser, String typeHistoTrajet);
	List<Trajet> getTrajetsEnCoursById(int idUser, String typeHistoTrajet);
	List<Trajet> getTrajetsEffectuesById(int idUser);
	List<Trajet> getTrajetsProposesById(int idUser);
}