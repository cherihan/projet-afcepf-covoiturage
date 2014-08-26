package fr.afcepf.atod21.coVoiturage.servicesImpl;

import javax.ws.rs.Path;

import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;
import fr.afcepf.atod21.coVoiturage.services.IInscriptionTrajetServiceRest;

@Path("/inscriptionTrajet")
public class InscriptionTrajetServiceRest implements IInscriptionTrajetServiceRest {

    public InscriptionTrajetServiceRest() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void sInscrireTrajet(Trajet paramTrajet, Utilisateur paramUser) {
        // TODO Auto-generated method stub
        
    }

}
