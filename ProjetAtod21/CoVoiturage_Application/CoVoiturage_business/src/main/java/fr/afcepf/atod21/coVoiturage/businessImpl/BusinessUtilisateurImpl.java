package fr.afcepf.atod21.coVoiturage.businessImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.atod21.coVoiturage.business.IBusinessUtilisateur;
import fr.afcepf.atod21.coVoiturage.dao.IDaoUtilisateur;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;

@Service
@Transactional
public class BusinessUtilisateurImpl implements IBusinessUtilisateur {

	@Autowired
	private IDaoUtilisateur daoUtilisateur;
	
	@Override
	public void afficher() {
		daoUtilisateur.afficher();
	}

	@Override
	public void sInscrireTrajet(Integer idTrajet, Integer idUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seDesinscrireTrajet(Integer idTrajet, Integer idUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void annulerInscriptionTrajet(Integer idTrajet, Integer idUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Trajet rechercherTrajet(Date date, String villeDepart,
			String villeArrivee) {
		// TODO Auto-generated method stub
		return null;
	}



	


}
