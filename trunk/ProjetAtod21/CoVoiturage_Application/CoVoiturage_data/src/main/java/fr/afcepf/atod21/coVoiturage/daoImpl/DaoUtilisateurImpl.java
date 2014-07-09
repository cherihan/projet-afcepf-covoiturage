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
	public Utilisateur seConnecter(String email, String password) {

		String requete = "SELECT user FROM Utilisateur user WHERE user.email = :emailUser and user.password = :passwordUser";

		List<Utilisateur> liste = em.createQuery(requete, Utilisateur.class)
										.setParameter("emailUser", email)
										.setParameter("passwordUser", password).getResultList();
		if (liste.size() != 0)
			return liste.get(0);
		
		return null;
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

	@Override
	public List<Trajet> rechercherTrajet(Date dateDepart, String villeDepart,
			String villeArrivee, String statut) {
		System.out.println(" ----------- DAO --------------- rechercherAvecVilleArrivee");

		String requete = "SELECT t FROM Trajet t INNER JOIN fetch t.utilisateurs WHERE t.villeDepart.nom=:villeDepart "
				+ "AND t.villeArrivee.nom=:villeArrivee AND t.dateDepart=:dateDepart AND t.statut=:statut ";

		javax.persistence.Query query = em.createQuery(requete);
		query.setParameter("dateDepart", dateDepart);
		query.setParameter("villeDepart", villeDepart);
		query.setParameter("villeArrivee", villeArrivee);
		query.setParameter("statut", statut);

		List<Trajet> listResults = query.getResultList();
		System.out.println("----- DAO Size ----- " + listResults.size());
		
		
		

		return listResults;
	}

	@Override
	public List<Trajet> rechercherTrajetParVilleDepart(Date dateDepart,
			String villeDepart, String statut) {

		

		String requete = "SELECT t FROM Trajet t INNER JOIN fetch t.utilisateurs  "
				+ "WHERE t.villeDepart.nom=:villeDepart "
				+ "AND t.dateDepart=:dateDepart "
				+ "AND t.statut=:statut ";

		javax.persistence.Query query = em.createQuery(requete);
		query.setParameter("dateDepart", dateDepart);
		query.setParameter("villeDepart", villeDepart);
		query.setParameter("statut", statut);

		List<Trajet> listResults = query.getResultList();

		System.out.println("----- DAO Size ----- " + listResults.size());

		return listResults;
	}

	


}
