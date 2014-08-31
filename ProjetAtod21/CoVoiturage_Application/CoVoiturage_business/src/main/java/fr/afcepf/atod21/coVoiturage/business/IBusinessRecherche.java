package fr.afcepf.atod21.coVoiturage.business;

import java.util.Date;
import java.util.List;

import fr.afcepf.atod21.coVoiturage.business.dto.TrajetDto;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;

public interface IBusinessRecherche {

    List<Trajet> rechercherTrajet(Date dateDepart, String villeDepart, String villeArrivee);
    List<TrajetDto> rechercherTrajetDto(Date dateDepart, String villeDepart, String villeArrivee);
    List<Trajet> rechercherTrajetParVilleDepart(Date dateDepart, String villeDepart);
    List<TrajetDto> rechercherTrajetParVilleDepartDto(Date dateDepart, String villeDepart);

}
