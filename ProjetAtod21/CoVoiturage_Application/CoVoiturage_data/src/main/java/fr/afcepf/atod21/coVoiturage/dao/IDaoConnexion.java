package fr.afcepf.atod21.coVoiturage.dao;

import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;

public interface IDaoConnexion {

    Utilisateur seConnecter(String email, String password);
    void seDeconnecter(Utilisateur utilisateur);

}
