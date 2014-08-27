package fr.afcepf.atod21.coVoiturage.services;

import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;

public interface IInscriptionTrajetServiceRest {

    boolean sInscrireTrajetDto(Integer IdTrajet, Integer IdUser);
    //void seDesinscrireTrajet(Integer idTrajet, Integer idUser);

}
