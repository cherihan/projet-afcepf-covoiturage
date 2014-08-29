package fr.afcepf.atod21.coVoiturage.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import fr.afcepf.atod21.coVoiturage.business.dto.TrajetDto;

@WebService
public interface IOrchestrateurSoap {

    @WebMethod
    List<TrajetDto> rechercherTrajetSOAP(Date dateDepart, String villeDepart, String villeArrivee);
    
    @WebMethod
    List<TrajetDto> rechercherTrajetParVilleDepartSOAP(Date dateDepart, String villeDepart);
    
    @WebMethod
    int authentifierClient(int paramApplicationId) throws FileNotFoundException, Exception, IOException, Throwable;
    
    @WebMethod
    public boolean entryMethod(int idApplication, int idUser, int IdTrajet) throws FileNotFoundException, Exception, IOException, Throwable;
}
