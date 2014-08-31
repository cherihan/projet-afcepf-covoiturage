package fr.afcepf.atod21.coVoiturage.servicesImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.afcepf.atod21.coVoiturage.business.IBusinessRecherche;
import fr.afcepf.atod21.coVoiturage.business.dto.ListTrajetsDto;
import fr.afcepf.atod21.coVoiturage.common.Common;
import fr.afcepf.atod21.coVoiturage.services.IRechercheTrajetJsonRest;

@Path("/rechercheTrajet")
public class RechercheTrajetRestJson implements IRechercheTrajetJsonRest {

    IBusinessRecherche businessRecherche;
    
    public void setBusinessRecherche(IBusinessRecherche paramBusinessRecherche) {
        businessRecherche = paramBusinessRecherche;
    }
    
    //CALL => http://localhost:8080/CoVoiturage_web/ws/REST3/rechercheTrajet/json/2015-01-01 10:00:00/Paris/Lyon
    @Override
    @Path("/json/{date}/{depart}/{arrivee}")
    @GET
    //@Produces(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    public ListTrajetsDto rechercherTrajetRestJSon(@PathParam("date") String paramDateDepart,
                                                    @PathParam("depart") String paramVilleDepart,
                                                    @PathParam("arrivee") String paramVilleArrivee) {
        
    	ListTrajetsDto liste = new ListTrajetsDto();
    	liste.setListeTrajetsDto(businessRecherche.rechercherTrajetDto(Common.convertDateWS(paramDateDepart), paramVilleDepart, paramVilleArrivee));
    	
    	return liste;
    }

}
