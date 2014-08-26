package fr.afcepf.atod21.coVoiturage.services;

import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;

import javax.jws.WebService;

@WebService
public interface IInscriptionTrajetServiceSoap {

    void sInscrireTrajet(Trajet trajet, Utilisateur user);
    //void seDesinscrireTrajet(Integer idTrajet, Integer idUser);

}
