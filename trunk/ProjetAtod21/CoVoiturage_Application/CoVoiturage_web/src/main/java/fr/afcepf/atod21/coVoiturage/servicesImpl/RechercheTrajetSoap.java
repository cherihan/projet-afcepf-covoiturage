package fr.afcepf.atod21.coVoiturage.servicesImpl;

import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import fr.afcepf.atod21.coVoiturage.business.IBusinessRecherche;
import fr.afcepf.atod21.coVoiturage.business.dto.TrajetDto;
import fr.afcepf.atod21.coVoiturage.services.IRechercheTrajetServiceSoap;

@WebService(endpointInterface = "fr.afcepf.atod21.coVoiturage.services.IRechercheTrajetServiceSoap")
public class RechercheTrajetSoap implements IRechercheTrajetServiceSoap {


    IBusinessRecherche businessRecherche;
    
    public void setBusinessRecherche(IBusinessRecherche paramBusinessRecherche) {
        businessRecherche = paramBusinessRecherche;
    }

    //CALL =>  http://localhost:8080/CoVoiturage_web/ws/SOAP/rechercheTrajet?wsdl
    @Override
    @WebMethod
    public List<TrajetDto> rechercherTrajetSOAP(Date paramDateDepart, String paramVilleDepart, String paramVilleArrivee) {

        return businessRecherche.rechercherTrajetDto(paramDateDepart, paramVilleDepart, paramVilleArrivee);
    }

}
