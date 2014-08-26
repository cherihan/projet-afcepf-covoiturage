package fr.afcepf.atod21.coVoiturage.servicesImpl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.atod21.coVoiturage.dao.IDaoTrajet;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;
import fr.afcepf.atod21.coVoiturage.services.IInscriptionTrajetServiceSoap;

@WebService(endpointInterface = "fr.afcepf.atod21.coVoiturage.services.IInscriptionTrajetSoap")
public class InscriptionTrajetServiceSoap implements IInscriptionTrajetServiceSoap {

    @Autowired
    IDaoTrajet daoTrajet;
    
    public void setDaoTrajet(IDaoTrajet paramDaoTrajet) {
        daoTrajet = paramDaoTrajet;
    }

    public InscriptionTrajetServiceSoap() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void sInscrireTrajet(Trajet paramTrajet, Utilisateur paramUser) {
        // TODO Auto-generated method stub
        
    }

}
