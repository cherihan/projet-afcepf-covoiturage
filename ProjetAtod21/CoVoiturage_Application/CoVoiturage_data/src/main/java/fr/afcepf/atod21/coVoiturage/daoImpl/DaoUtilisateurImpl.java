package fr.afcepf.atod21.coVoiturage.daoImpl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.atod21.coVoiturage.dao.IDaoUtilisateur;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;
import fr.afcepf.atod21.coVoiturage.utils.Consts;

@Component
@Transactional
public class DaoUtilisateurImpl implements IDaoUtilisateur {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void afficher() {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void changerPassword(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Integer creerCompte(Utilisateur user) {
		em.persist(user.getAdresse().getVille());
		em.persist(user.getAdresse());
		em.persist(user);
		em.flush();
		
		return user.getIdUtilisateur();
	}

	@Override
	public Utilisateur getUserById(Integer idUser) {
		
		Utilisateur user = em.find(Utilisateur.class, idUser);
		
		
		return user;
	}

	


}
