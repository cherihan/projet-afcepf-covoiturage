package fr.afcepf.atod21.coVoiturage.businessImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.atod21.coVoiturage.business.IBusinessTrajet;
import fr.afcepf.atod21.coVoiturage.dao.IDaoTrajet;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;

@Service
@Transactional
public class BusinessTrajetImpl implements IBusinessTrajet {

	@Autowired
	private IDaoTrajet daoTrajet;
	
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
