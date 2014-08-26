package fr.afcepf.atod21.coVoiturage.servicesImpl;

import javax.jws.WebService;

import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;
import fr.afcepf.atod21.coVoiturage.services.IInscriptionTrajetServiceSoap;

@WebService(endpointInterface = "fr.afcepf.atod21.coVoiturage.services.IInscriptionTrajetSoap")
public class InscriptionTrajetServiceSoap implements IInscriptionTrajetServiceSoap {

    public InscriptionTrajetServiceSoap() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void sInscrireTrajet(Trajet paramTrajet, Utilisateur paramUser) {
        // TODO Auto-generated method stub
        
    }

}
