package fr.afcepf.atod21.coVoiturage.servicesImpl;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.atod21.coVoiturage.dao.IDaoRecherche;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.services.IRechercheTrajetServiceRest;

@Path("/recherche")
public class RechercheTrajetServiceRest implements IRechercheTrajetServiceRest {

    @Autowired
    IDaoRecherche daoRechercheRest;
    
    public void setDaoRecherche(IDaoRecherche paramDaoRecherche) {
        daoRechercheRest = paramDaoRecherche;
    }
    
    public RechercheTrajetServiceRest() {
        // TODO Auto-generated constructor stub
    }

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

}
