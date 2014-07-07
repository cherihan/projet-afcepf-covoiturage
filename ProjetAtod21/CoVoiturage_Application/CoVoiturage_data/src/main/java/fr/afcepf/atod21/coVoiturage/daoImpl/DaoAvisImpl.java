package fr.afcepf.atod21.coVoiturage.daoImpl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.atod21.coVoiturage.dao.IDaoAvis;
import fr.afcepf.atod21.coVoiturage.dao.IDaoTrajet;
import fr.afcepf.atod21.coVoiturage.entity.Avis;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;

@Component
@Transactional
public class DaoAvisImpl implements IDaoAvis {

	@PersistenceContext
	private EntityManager em;
	



	@Override
	public Trajet creerAvis(int idUser, String contenu, int note, Avis avis) {
		// TODO Auto-generated method stub
		return null;
	}

}
