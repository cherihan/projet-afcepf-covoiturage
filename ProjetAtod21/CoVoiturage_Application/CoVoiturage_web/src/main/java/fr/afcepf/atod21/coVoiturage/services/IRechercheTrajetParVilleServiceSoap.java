package fr.afcepf.atod21.coVoiturage.services;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import fr.afcepf.atod21.coVoiturage.business.dto.TrajetDto;

@WebService
public interface IRechercheTrajetParVilleServiceSoap {

    List<TrajetDto> rechercherTrajetParVilleDepartSOAP(Date dateDepart, String villeDepart);

}
