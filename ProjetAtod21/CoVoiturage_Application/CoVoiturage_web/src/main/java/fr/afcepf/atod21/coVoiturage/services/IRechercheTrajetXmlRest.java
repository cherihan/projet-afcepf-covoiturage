package fr.afcepf.atod21.coVoiturage.services;

import java.util.List;

import fr.afcepf.atod21.coVoiturage.business.dto.TrajetDto;


public interface IRechercheTrajetXmlRest {

    List<TrajetDto> rechercherTrajetRestXml(String paramDateDepart, String paramVilleDepart, String paramVilleArrivee);
}
