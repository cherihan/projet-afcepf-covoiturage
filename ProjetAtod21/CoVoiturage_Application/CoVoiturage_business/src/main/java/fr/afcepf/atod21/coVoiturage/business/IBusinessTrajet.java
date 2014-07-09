package fr.afcepf.atod21.coVoiturage.business;

import java.util.Date;
import java.util.List;

import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Ville;

public interface IBusinessTrajet {

	void ajouterCommentaireTrajet(int idTrajet, int idUser);
	void creerTrajet(Trajet trajet);
	void supprimerTrajet(int idTrajet, int idUser);
	List<Ville> getAllVilles();

}
