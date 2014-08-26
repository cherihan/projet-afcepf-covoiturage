package fr.afcepf.atod21.coVoiturage.services;

import java.util.Date;
import java.util.List;

import fr.afcepf.atod21.coVoiturage.entity.Trajet;

import javax.jws.WebService;

@WebService
public interface IRechercheTrajetServiceSoap {

    List<Trajet> rechercherTrajet(Date dateDepart, String villeDepart, String villeArrivee);
    List<Trajet> rechercherTrajetParVilleDepart(Date dateDepart, String villeDepart);

}
