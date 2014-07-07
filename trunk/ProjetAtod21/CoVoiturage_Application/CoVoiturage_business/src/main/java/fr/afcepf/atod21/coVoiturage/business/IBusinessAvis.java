package fr.afcepf.atod21.coVoiturage.business;

import fr.afcepf.atod21.coVoiturage.entity.Avis;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;

public interface IBusinessAvis {

	Trajet creerAvis(int idUser, String contenu, int note, Avis avis);

}
