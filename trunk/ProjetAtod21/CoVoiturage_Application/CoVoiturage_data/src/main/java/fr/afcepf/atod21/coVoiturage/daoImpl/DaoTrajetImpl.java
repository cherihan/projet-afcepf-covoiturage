package fr.afcepf.atod21.coVoiturage.daoImpl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.atod21.coVoiturage.dao.IDaoTrajet;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;

@Component
@Transactional
public class DaoTrajetImpl implements IDaoTrajet {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void ajouterCommentaireTrajet(int idTrajet, int idUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Trajet creerTrajet(int idUser, String villeDepart,
			String villeArrivee, Date date, int tarif, int nbPassagers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerTrajet(int idTrajet, int idUser) {
		// TODO Auto-generated method stub
		
	}

}
