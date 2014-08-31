package fr.afcepf.atod21.coVoiturage.servicesImpl;

import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import fr.afcepf.atod21.coVoiturage.business.IBusinessRecherche;
import fr.afcepf.atod21.coVoiturage.business.dto.TrajetDto;
import fr.afcepf.atod21.coVoiturage.services.IRechercheTrajetParVilleServiceSoap;

@WebService(endpointInterface = "fr.afcepf.atod21.coVoiturage.services.IRechercheTrajetParVilleServiceSoap")
public class RechercheTrajetParVilleSoap implements IRechercheTrajetParVilleServiceSoap {


    IBusinessRecherche businessRecherche;
    
    public void setBusinessRecherche(IBusinessRecherche paramBusinessRecherche) {
        businessRecherche = paramBusinessRecherche;
    }

    //CALL =>  http://localhost:8080/CoVoiturage_web/ws/SOAP/rechercheTrajetParVille?wsdl
    @Override
    @WebMethod
    public List<TrajetDto> rechercherTrajetParVilleDepartSOAP(Date paramDateDepart, String paramVilleDepart) {
    
        return businessRecherche.rechercherTrajetParVilleDepartDto(paramDateDepart, paramVilleDepart);
    }

}
