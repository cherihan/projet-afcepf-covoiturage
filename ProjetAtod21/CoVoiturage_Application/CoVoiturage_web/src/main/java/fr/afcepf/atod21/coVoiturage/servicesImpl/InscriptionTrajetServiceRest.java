package fr.afcepf.atod21.coVoiturage.servicesImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.afcepf.atod21.coVoiturage.business.IBusinessTrajet;
import fr.afcepf.atod21.coVoiturage.services.IInscriptionTrajetServiceRest;

@Path("/inscriptionTrajet")
public class InscriptionTrajetServiceRest implements IInscriptionTrajetServiceRest {

    //@Autowired
    private IBusinessTrajet businessTrajet;
    
    public void setBusinessTrajet(IBusinessTrajet paramBusinessTrajet) {
        businessTrajet = paramBusinessTrajet;
    }

    @Override
    @Path("/{IdTrajet}/{IdUser}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public boolean sInscrireTrajetDto(@PathParam("IdTrajet") Integer IdTrajet, @PathParam("IdUser") Integer IdUser) {
       return businessTrajet.sInscrireTrajetSoap(IdTrajet, IdUser);
    }

    @Override
    @Path("/desinscrire/{IdTrajet}/{IdUser}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public boolean seDesinscrireTrajet(@PathParam("IdTrajet") Integer IdTrajet, @PathParam("IdUser") Integer IdUser) {
        return businessTrajet.seDesinscrireTrajet(IdTrajet, IdUser);
    }
    
    
    

    
}
