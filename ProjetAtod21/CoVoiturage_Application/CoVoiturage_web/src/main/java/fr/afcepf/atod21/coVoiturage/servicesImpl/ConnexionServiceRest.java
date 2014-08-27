package fr.afcepf.atod21.coVoiturage.servicesImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.atod21.coVoiturage.business.IBusinessConnexion;
import fr.afcepf.atod21.coVoiturage.business.dto.UtilisateurDto;
import fr.afcepf.atod21.coVoiturage.dao.IDaoConnexion;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;
import fr.afcepf.atod21.coVoiturage.services.IConnexionServiceRest;

@Path("/connexion") 
public class ConnexionServiceRest implements IConnexionServiceRest {

    //@Autowired
   private IBusinessConnexion businessConnexion;
   
   public void setBusinessConnexion(IBusinessConnexion paramBusinessConnexion) {
       businessConnexion = paramBusinessConnexion;
   }

@Override
@Path("/{email}/{password}")
@GET
@Produces("application/xml")
public UtilisateurDto seConnecterSOAP(@PathParam("email") String email, @PathParam("password") String password) {
    return businessConnexion.seConnecterSOAP(email, password);
}
   
  

}
