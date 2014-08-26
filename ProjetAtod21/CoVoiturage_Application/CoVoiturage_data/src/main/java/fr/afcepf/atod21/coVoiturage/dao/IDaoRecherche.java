package fr.afcepf.atod21.coVoiturage.dao;

import java.util.Date;
import java.util.List;

import fr.afcepf.atod21.coVoiturage.entity.Trajet;

public interface IDaoRecherche {

    List<Trajet> rechercherTrajet(Date dateDepart, String villeDepart, String villeArrivee);
    List<Trajet> rechercherTrajetParVilleDepart(Date dateDepart, String villeDepart);

}
