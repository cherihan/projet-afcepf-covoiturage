package fr.afcepf.atod21.coVoiturage.businessImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.atod21.coVoiturage.business.IBusinessAvis;
import fr.afcepf.atod21.coVoiturage.dao.IDaoAvis;
import fr.afcepf.atod21.coVoiturage.entity.Avis;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;

@Service
@Transactional
public class BusinessAvisImpl implements IBusinessAvis {

	@Autowired
	private IDaoAvis daoAvis;
	
	@Override
	public Trajet creerAvis(int idUser, String contenu, int note, Avis avis) {
		// TODO Auto-generated method stub
		return null;
	}

}
