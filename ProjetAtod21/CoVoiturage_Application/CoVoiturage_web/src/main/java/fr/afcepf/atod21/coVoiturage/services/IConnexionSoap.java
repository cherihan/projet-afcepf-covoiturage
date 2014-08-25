package fr.afcepf.atod21.coVoiturage.services;

import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;
import javax.jws.WebService;

@WebService
public interface IConnexionSoap {

    Utilisateur seConnecter(String email, String password);
    //void seDeconnecter(Utilisateur utilisateur);

}
