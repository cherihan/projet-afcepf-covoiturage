package fr.afcepf.atod21.coVoiturage.business;

import fr.afcepf.atod21.coVoiturage.business.dto.UtilisateurDto;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;

public interface IBusinessConnexion {

    Utilisateur seConnecter(String email, String password);
    UtilisateurDto seConnecterSOAP(String email, String password);
    void seDeconnecter(Utilisateur utilisateur);

}
