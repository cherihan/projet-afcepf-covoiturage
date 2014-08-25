package fr.afcepf.atod21.coVoiturage.services;

import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;

public interface IInscriptionTrajetRest {

    void sInscrireTrajet(Trajet trajet, Utilisateur user);
    //void seDesinscrireTrajet(Integer idTrajet, Integer idUser);

}
