package fr.afcepf.atod21.coVoiturage.dao;

import java.util.List;

import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;
import fr.afcepf.atod21.coVoiturage.entity.Ville;

public interface IDaoTrajet {

	void ajouterCommentaireTrajet(int idTrajet, int idUser);
	Integer creerTrajet(Trajet trajet, Utilisateur user);
	boolean supprimerTrajet(Trajet trajet, Utilisateur user);
	List<Ville> getAllVilles();
	List<Trajet> getAllHistoTrajets(int idUser);
    List<Trajet> getHistoTrajetsByType(int idUser, String typeHistoTrajet);
    
    boolean sInscrireTrajet(Trajet trajet, Utilisateur user);
    boolean seDesinscrireTrajet(Integer idTrajet, Integer idUser);
    boolean annulerInscriptionTrajet(Integer idTrajet, Integer idUser);
    
    Trajet rechercheById(Integer IdTrajet);

}