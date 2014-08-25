package fr.afcepf.atod21.coVoiturage.servicesImpl;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.services.IRechercheTrajetSoap;

@WebService(endpointInterface = "fr.afcepf.atod21.coVoiturage.services.IRechercheTrajetSoap")
public class RechercheTrajetSoapImpl implements IRechercheTrajetSoap {

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
