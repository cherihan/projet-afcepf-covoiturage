package fr.afcepf.atod21.coVoiturage.servicesImpl;

import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.atod21.coVoiturage.business.IBusinessRecherche;
import fr.afcepf.atod21.coVoiturage.business.dto.TrajetDto;
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
    public List<TrajetDto> rechercherTrajetSOAP(Date paramDateDepart, String paramVilleDepart, String paramVilleArrivee) {

        return businessRecherche.rechercherTrajetSOAP(paramDateDepart, paramVilleDepart, paramVilleArrivee);
    }

    @WebMethod
    @Override
    public List<TrajetDto> rechercherTrajetParVilleDepartSOAP(Date paramDateDepart, String paramVilleDepart) {
    
        return businessRecherche.rechercherTrajetParVilleDepartSOAP(paramDateDepart, paramVilleDepart);
    }

}
