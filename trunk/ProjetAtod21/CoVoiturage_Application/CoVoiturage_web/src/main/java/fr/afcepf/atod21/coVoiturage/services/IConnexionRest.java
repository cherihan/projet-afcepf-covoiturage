package fr.afcepf.atod21.coVoiturage.services;

import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;

public interface IConnexionRest {

    Utilisateur seConnecter(String email, String password);
    //void seDeconnecter(Utilisateur utilisateur);

}
