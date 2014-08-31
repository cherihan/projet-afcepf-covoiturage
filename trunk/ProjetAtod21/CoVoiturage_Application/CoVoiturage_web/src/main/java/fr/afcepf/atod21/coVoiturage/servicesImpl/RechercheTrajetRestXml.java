package fr.afcepf.atod21.coVoiturage.servicesImpl;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.afcepf.atod21.coVoiturage.business.IBusinessRecherche;
import fr.afcepf.atod21.coVoiturage.business.dto.TrajetDto;
import fr.afcepf.atod21.coVoiturage.common.Common;
import fr.afcepf.atod21.coVoiturage.services.IRechercheTrajetXmlRest;

@Path("/rechercheTrajet")
public class RechercheTrajetRestXml implements IRechercheTrajetXmlRest {

    IBusinessRecherche businessRecherche;
    
    public void setBusinessRecherche(IBusinessRecherche paramBusinessRecherche) {
        businessRecherche = paramBusinessRecherche;
    }

    //CALL => http://localhost:8080/CoVoiturage_web/ws/REST1/rechercheTrajet/xml/2015-01-01 10:00:00/Paris/Lyon
    @Override
    @Path("/xml/{date}/{depart}/{arrivee}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<TrajetDto> rechercherTrajetRestXml(@PathParam("date") String paramDateDepart,
                                                   @PathParam("depart") String paramVilleDepart,
                                                   @PathParam("arrivee") String paramVilleArrivee) {
        
        return businessRecherche.rechercherTrajetDto(Common.convertDateWS(paramDateDepart), paramVilleDepart, paramVilleArrivee);

    }
    
}
