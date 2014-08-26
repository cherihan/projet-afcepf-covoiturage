package fr.afcepf.atod21.coVoiturage.servicesImpl;

import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.atod21.coVoiturage.business.IBusinessRecherche;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.services.IRechercheTrajetServiceSoap;

@WebService(endpointInterface = "fr.afcepf.atod21.coVoiturage.services.IRechercheTrajetServiceSoap")
public class RechercheTrajetServiceSoap implements IRechercheTrajetServiceSoap {

    @Autowired
    IBusinessRecherche businessRecherche;
    
    public void setBusinessRecherche(IBusinessRecherche paramBusinessRecherche) {
        businessRecherche = paramBusinessRecherche;
    }

    @Override
    @WebMethod
    public List<Trajet> rechercherTrajet(Date paramDateDepart, String paramVilleDepart, String paramVilleArrivee) {
        
        return businessRecherche.rechercherTrajet(paramDateDepart, paramVilleDepart, paramVilleArrivee);
    }

    @Override
    @WebMethod
    public List<Trajet> rechercherTrajetParVilleDepart(Date paramDateDepart, String paramVilleDepart) {
        
        return businessRecherche.rechercherTrajetParVilleDepart(paramDateDepart, paramVilleDepart);
    }


}
