package fr.afcepf.atod21.coVoiturage.servicesImpl;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.atod21.coVoiturage.dao.IDaoConnexion;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;
import fr.afcepf.atod21.coVoiturage.services.IConnexionServiceRest;

@Path("/connexion") 
public class ConnexionServiceRest implements IConnexionServiceRest {

    @Autowired
    IDaoConnexion daoConnexion;
    
    public void setDaoConnexion(IDaoConnexion paramDaoConnexion) {
        daoConnexion = paramDaoConnexion;
    }

    public ConnexionServiceRest() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public Utilisateur seConnecter(String paramEmail, String paramPassword) {
        // TODO Auto-generated method stub
        return null;
    }

}
