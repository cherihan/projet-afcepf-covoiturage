package fr.afcepf.atod21.coVoiturage.daoImpl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.atod21.coVoiturage.dao.IDaoUtilisateur;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;

@Component
@Transactional
public class DaoUtilisateurImpl implements IDaoUtilisateur {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void afficher() {
			System.out.println("Dans DaoUtilisateurImpl.afficher()");		
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

	@Override
	public Utilisateur seConnecter(String email, String password) {

		Utilisateur user = null;
		try {
			String requete = "SELECT user FROM Utilisateur user WHERE user.email = :emailUser and user.password = :passwordUser";
			user = em.createQuery(requete, Utilisateur.class)
										.setParameter("emailUser", email)
										.setParameter("passwordUser", password).getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;

	}

	@Override
	public void seDeconnecter(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changerPassword(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur creerCompte() {
		// TODO Auto-generated method stub
		return null;
	}

	


}
