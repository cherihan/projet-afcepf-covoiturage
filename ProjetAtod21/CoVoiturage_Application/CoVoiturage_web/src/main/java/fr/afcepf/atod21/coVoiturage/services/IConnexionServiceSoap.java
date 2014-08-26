package fr.afcepf.atod21.coVoiturage.services;

import javax.jws.WebService;

import fr.afcepf.atod21.coVoiturage.business.dto.UtilisateurDto;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;

@WebService
public interface IConnexionServiceSoap {

    UtilisateurDto seConnecterSOAP(String email, String password);
    //void seDeconnecter(Utilisateur utilisateur);

}
