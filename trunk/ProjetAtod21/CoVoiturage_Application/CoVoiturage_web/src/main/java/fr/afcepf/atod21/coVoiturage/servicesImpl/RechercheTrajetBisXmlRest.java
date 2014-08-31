package fr.afcepf.atod21.coVoiturage.servicesImpl;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

import fr.afcepf.atod21.coVoiturage.business.IBusinessRecherche;
import fr.afcepf.atod21.coVoiturage.business.dto.TrajetDto;
import fr.afcepf.atod21.coVoiturage.common.Common;
import fr.afcepf.atod21.coVoiturage.services.IRechercheTrajetBisXmlRest;

@Path("/rechercheTrajetParVille")
@XmlRootElement
public class RechercheTrajetBisXmlRest implements IRechercheTrajetBisXmlRest {

    IBusinessRecherche businessRecherche;
    
    public void setBusinessRecherche(IBusinessRecherche paramBusinessRecherche) {
        businessRecherche = paramBusinessRecherche;
    }

    //CALL => http://localhost:8080/CoVoiturage_web/ws/REST2/rechercheTrajetParVille/xml/2015-01-01 10:00:00/Paris/Lyon
    @Override
    @Path("/xml/{date}/{depart}/{arrivee}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<TrajetDto> rechercherTrajetParVilleDepartRestXml(@PathParam("date") String paramDateDepart,
                                                                 @PathParam("depart") String paramVilleDepart) {
        
        return businessRecherche.rechercherTrajetParVilleDepartDto(Common.convertDateWS(paramDateDepart), paramVilleDepart);
    }

}
