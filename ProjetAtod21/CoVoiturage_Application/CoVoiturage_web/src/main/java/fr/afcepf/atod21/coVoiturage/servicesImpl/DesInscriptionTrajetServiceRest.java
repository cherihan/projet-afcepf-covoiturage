package fr.afcepf.atod21.coVoiturage.servicesImpl;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.afcepf.atod21.coVoiturage.business.IBusinessTrajet;
import fr.afcepf.atod21.coVoiturage.services.IDesInscriptionTrajetServiceRest;

@Path("/desInscriptionTrajet")
public class DesInscriptionTrajetServiceRest implements
        IDesInscriptionTrajetServiceRest {

    private IBusinessTrajet businessTrajet;

    public void setBusinessTrajet(IBusinessTrajet paramBusinessTrajet) {
        businessTrajet = paramBusinessTrajet;
    }

    @Override
    @Path("/{IdTrajet}/{IdUser}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public boolean seDesinscrireTrajet(@PathParam("IdTrajet") Integer IdTrajet,
            @PathParam("IdUser") Integer IdUser) {
        businessTrajet.seDesinscrireTrajet(IdTrajet, IdUser);
        return true;
    }

}
