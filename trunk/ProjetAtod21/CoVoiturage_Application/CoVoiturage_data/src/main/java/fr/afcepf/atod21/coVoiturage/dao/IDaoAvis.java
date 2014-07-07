package fr.afcepf.atod21.coVoiturage.dao;

import fr.afcepf.atod21.coVoiturage.entity.Avis;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;

public interface IDaoAvis {
	
	Trajet creerAvis(int idUser, String contenu, int note, Avis avis);

}
