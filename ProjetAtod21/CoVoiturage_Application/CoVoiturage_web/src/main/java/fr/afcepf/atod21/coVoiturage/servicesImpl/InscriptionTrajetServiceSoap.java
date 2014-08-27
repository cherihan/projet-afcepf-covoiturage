package fr.afcepf.atod21.coVoiturage.servicesImpl;

import javax.jws.WebMethod;
import javax.jws.WebService;

import fr.afcepf.atod21.coVoiturage.business.IBusinessTrajet;
import fr.afcepf.atod21.coVoiturage.services.IInscriptionTrajetServiceSoap;

@WebService(endpointInterface = "fr.afcepf.atod21.coVoiturage.services.IInscriptionTrajetServiceSoap")
public class InscriptionTrajetServiceSoap implements IInscriptionTrajetServiceSoap {
    
    IBusinessTrajet businessTrajet;
    
    public void setBusinessTrajet(IBusinessTrajet paramBusinessTrajet) {
        businessTrajet = paramBusinessTrajet;
    }
    
    
    @Override
    @WebMethod
    public boolean sInscrireTrajetDto(Integer IdTrajet, Integer IdUser) {
      businessTrajet.sInscrireTrajetSoap(IdTrajet, IdUser);    
        return true;
    }

  
    

}
