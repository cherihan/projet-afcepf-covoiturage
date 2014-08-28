package fr.afcepf.atod21.coVoiturage.servicesImpl;

import javax.jws.WebMethod;

import fr.afcepf.atod21.coVoiturage.business.IBusinessTrajet;
import fr.afcepf.atod21.coVoiturage.services.desInscriptionTrajetServiceSoap;

public class DesInscriptionTrajetServiceSoap implements desInscriptionTrajetServiceSoap {

IBusinessTrajet businessTrajet;
    
    public void setBusinessTrajet(IBusinessTrajet paramBusinessTrajet) {
        businessTrajet = paramBusinessTrajet;
    }
    
    @Override
    @WebMethod
    public boolean desInscrireTrajetDto(int idTrajet, int idUser) {
        businessTrajet.seDesinscrireTrajet(idTrajet, idUser);
        return true;
    }
}
