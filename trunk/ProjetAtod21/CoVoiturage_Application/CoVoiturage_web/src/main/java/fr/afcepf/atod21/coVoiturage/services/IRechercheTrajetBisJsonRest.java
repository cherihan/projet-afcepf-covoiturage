package fr.afcepf.atod21.coVoiturage.services;

import java.util.List;

import fr.afcepf.atod21.coVoiturage.business.dto.TrajetDto;


public interface IRechercheTrajetBisJsonRest {

    List<TrajetDto> rechercherTrajetParVilleDepartRestJson(String paramDateDepart, String paramVilleDepart);

}
