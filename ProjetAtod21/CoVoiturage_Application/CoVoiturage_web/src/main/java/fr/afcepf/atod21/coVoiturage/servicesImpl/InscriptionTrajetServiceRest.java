package fr.afcepf.atod21.coVoiturage.servicesImpl;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.atod21.coVoiturage.dao.IDaoTrajet;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;
import fr.afcepf.atod21.coVoiturage.services.IInscriptionTrajetServiceRest;

@Path("/inscriptionTrajet")
public class InscriptionTrajetServiceRest implements IInscriptionTrajetServiceRest {

    @Autowired
    IDaoTrajet daoTrajet;
    
    public void setDaoTrajet(IDaoTrajet paramDaoTrajet) {
        daoTrajet = paramDaoTrajet;
    }
    
    public InscriptionTrajetServiceRest() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void sInscrireTrajet(Trajet paramTrajet, Utilisateur paramUser) {
        // TODO Auto-generated method stub
        
    }

}
