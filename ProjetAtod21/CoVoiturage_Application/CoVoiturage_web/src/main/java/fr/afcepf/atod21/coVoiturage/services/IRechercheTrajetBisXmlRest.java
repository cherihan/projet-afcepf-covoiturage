package fr.afcepf.atod21.coVoiturage.services;

import java.util.List;

import fr.afcepf.atod21.coVoiturage.business.dto.TrajetDto;


public interface IRechercheTrajetBisXmlRest {

    List<TrajetDto> rechercherTrajetParVilleDepartRestXml(String paramDateDepart, String paramVilleDepart);

}
