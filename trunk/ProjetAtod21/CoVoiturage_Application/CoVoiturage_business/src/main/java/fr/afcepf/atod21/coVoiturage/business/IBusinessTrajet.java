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
	List<Trajet> getAllHistoTrajets(int idUser);
    List<Trajet> getHistoTrajetsAsConductorByType(int idUser, String typeHistoTrajet);
    List<Trajet> getHistoTrajetsAsPassengerByType(int idUser, String typeHistoTrajet);
}