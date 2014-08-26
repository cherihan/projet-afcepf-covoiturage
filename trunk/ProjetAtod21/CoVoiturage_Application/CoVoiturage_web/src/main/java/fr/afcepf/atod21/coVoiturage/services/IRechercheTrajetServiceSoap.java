package fr.afcepf.atod21.coVoiturage.services;

import java.util.Date;
import java.util.List;

import fr.afcepf.atod21.coVoiturage.business.dto.TrajetDto;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;

import javax.jws.WebService;

@WebService
public interface IRechercheTrajetServiceSoap {

    List<TrajetDto> rechercherTrajetSOAP(Date dateDepart, String villeDepart, String villeArrivee);
    List<TrajetDto> rechercherTrajetParVilleDepartSOAP(Date dateDepart, String villeDepart);

}
