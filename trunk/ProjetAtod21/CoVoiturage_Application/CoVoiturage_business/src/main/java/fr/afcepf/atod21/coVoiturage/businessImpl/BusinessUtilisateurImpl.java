package fr.afcepf.atod21.coVoiturage.businessImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.atod21.coVoiturage.business.IBusinessUtilisateur;
import fr.afcepf.atod21.coVoiturage.dao.IDaoUtilisateur;

@Service
@Transactional
public class BusinessUtilisateurImpl implements IBusinessUtilisateur {

	@Autowired
	private IDaoUtilisateur daoUtilisateur;
	
	@Override
	public void afficher() {
		daoUtilisateur.afficher();
	}

}
