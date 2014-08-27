package fr.afcepf.atod21.coVoiturage.servicesImpl;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.atod21.coVoiturage.business.IBusinessConnexion;
import fr.afcepf.atod21.coVoiturage.business.dto.UtilisateurDto;
import fr.afcepf.atod21.coVoiturage.services.IConnexionServiceSoap;

@WebService(endpointInterface = "fr.afcepf.atod21.coVoiturage.services.IConnexionServiceSoap")
public class ConnexionServiceSoap implements IConnexionServiceSoap {

    //@Autowired
    private IBusinessConnexion businessConnexion;

    public void setBusinessConnexion(IBusinessConnexion paramBusinessConnexion) {
        businessConnexion = paramBusinessConnexion;
    }

    @Override
    @WebMethod
    public UtilisateurDto seConnecterSOAP(String email, String password) {

        return businessConnexion.seConnecterSOAP(email, password);
    }

}
