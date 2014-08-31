package fr.afcepf.atod21.coVoiturage.services;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import fr.afcepf.atod21.coVoiturage.business.dto.TrajetDto;

@WebService
public interface IRechercheTrajetServiceSoap {

    List<TrajetDto> rechercherTrajetSOAP(Date dateDepart, String villeDepart, String villeArrivee);

}
