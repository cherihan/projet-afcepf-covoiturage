package fr.afcepf.atod21.coVoiturage.servicesImpl;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.atod21.coVoiturage.dao.IDaoUtilisateur;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;
import fr.afcepf.atod21.coVoiturage.services.IConnexionSoap;

@WebService(endpointInterface = "fr.afcepf.atod21.coVoiturage.services.IConnexionSoap")
public class ConnexionSoapImpl implements IConnexionSoap {

    @Autowired
    private IDaoUtilisateur daoUser;

    @Override
    @WebMethod
    public Utilisateur seConnecter(String paramEmail, String paramPassword) {
        // TODO Auto-generated method stub
        return null;
    }

}
