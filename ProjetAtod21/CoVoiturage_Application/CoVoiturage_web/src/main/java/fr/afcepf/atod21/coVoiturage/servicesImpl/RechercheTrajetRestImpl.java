package fr.afcepf.atod21.coVoiturage.servicesImpl;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Path;

import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.services.IRechercheTrajetRest;

@Path("/recherche")
public class RechercheTrajetRestImpl implements IRechercheTrajetRest {

    public RechercheTrajetRestImpl() {
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
