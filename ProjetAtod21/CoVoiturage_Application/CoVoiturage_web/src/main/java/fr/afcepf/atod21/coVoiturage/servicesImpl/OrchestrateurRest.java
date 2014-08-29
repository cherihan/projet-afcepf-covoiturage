package fr.afcepf.atod21.coVoiturage.servicesImpl;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Path;

import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;
import fr.afcepf.atod21.coVoiturage.services.IOrchestrateurRest;

@Path("/orchestrateur")
public class OrchestrateurRest implements IOrchestrateurRest {

    @Override
    public List<Trajet> rechercherTrajet(Date paramDateDepart,
            String paramVilleDepart, String paramVilleArrivee) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Trajet> rechercherTrajetParVilleDepart(Date paramDateDepart,
            String paramVilleDepart) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void sInscrireTrajet(Trajet paramTrajet, Utilisateur paramUser) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Utilisateur seConnecter(String paramEmail, String paramPassword) {
        // TODO Auto-generated method stub
        return null;
    }

}