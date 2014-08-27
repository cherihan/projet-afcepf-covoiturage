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
	List<Trajet> getAllHistoTrajets(int idUser);
    List<Trajet> getHistoTrajetsAsConductorByType(int idUser, String typeHistoTrajet);
    List<Trajet> getHistoTrajetsAsPassengerByType(int idUser, String typeHistoTrajet);

    boolean sInscrireTrajet(Trajet trajet, Utilisateur user);
    boolean seDesinscrireTrajet(Integer idTrajet, Integer idUser);
    boolean annulerInscriptionTrajet(Integer idTrajet, Integer idUser);
    
    Trajet rechercheById(Integer IdTrajet);

}