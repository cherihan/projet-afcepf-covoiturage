package fr.afcepf.atod21.coVoiturage.services;

import fr.afcepf.atod21.coVoiturage.business.dto.UtilisateurDto;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;

public interface IConnexionServiceRest {

    UtilisateurDto seConnecterSOAP(String email, String password);
    //void seDeconnecter(Utilisateur utilisateur);

}
