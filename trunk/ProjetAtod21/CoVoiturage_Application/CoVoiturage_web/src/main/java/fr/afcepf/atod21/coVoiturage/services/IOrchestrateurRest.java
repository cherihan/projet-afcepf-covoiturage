package fr.afcepf.atod21.coVoiturage.services;

import java.util.Date;
import java.util.List;

import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;

public interface IOrchestrateurRest {

    List<Trajet> rechercherTrajet(Date dateDepart, String villeDepart, String villeArrivee);
    List<Trajet> rechercherTrajetParVilleDepart(Date dateDepart, String villeDepart);

    void sInscrireTrajet(Trajet trajet, Utilisateur user);
    //void seDesinscrireTrajet(Integer idTrajet, Integer idUser);
    
    Utilisateur seConnecter(String email, String password);
    //void seDeconnecter(Utilisateur utilisateur);

}
