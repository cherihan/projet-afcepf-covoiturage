package fr.afcepf.atod21.coVoiturage.businessImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.atod21.coVoiturage.business.IBusinessTrajet;
import fr.afcepf.atod21.coVoiturage.dao.IDaoTrajet;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;
import fr.afcepf.atod21.coVoiturage.entity.Ville;

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
	public Integer creerTrajet(Trajet trajet, Utilisateur user) {

	return 	daoTrajet.creerTrajet(trajet, user);

	}

	@Override
	public void supprimerTrajet(int idTrajet, int idUser) {
		// TODO Auto-generated method stub

	}

	public void setDaoTrajet(IDaoTrajet daoTrajet) {
		this.daoTrajet = daoTrajet;
	}

	@Override
	public List<Ville> getAllVilles() {

		return daoTrajet.getAllVilles();
	}

}
