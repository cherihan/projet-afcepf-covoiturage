package fr.afcepf.atod21.coVoiturage.daoImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.atod21.coVoiturage.dao.IDaoTrajet;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;
import fr.afcepf.atod21.coVoiturage.entity.Ville;

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
	public void supprimerTrajet(int idTrajet, int idUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer creerTrajet(Trajet trajet, Utilisateur user) {

		trajet.setVilleDepart(em.find(Ville.class, trajet.getVilleDepart()
				.getIdVille()));
		trajet.setVilleArrivee(em.find(Ville.class, trajet.getVilleArrivee()
				.getIdVille()));

		List<Trajet> listTrajetsHasTrajet = new ArrayList<Trajet>();
		List<Utilisateur> listUsersHasTrajet = new ArrayList<Utilisateur>();
		listUsersHasTrajet.add(user);

		trajet.setUtilisateurs(listUsersHasTrajet);

		em.persist(trajet);

		user = em.find(Utilisateur.class, user.getIdUtilisateur());
		user.getTrajets().add(trajet);
		em.persist(user);
		em.flush();
		
		return trajet.getIdTrajet();

	}

	@Override
	public List<Ville> getAllVilles() {

		return em.createQuery("SELECT v FROM Ville v").getResultList();
	}

	@Override
	public List<Trajet> getTrajetsEnCoursById(int idUser) {
		
/*		
		String req = "SELECT u.trajets FROM Utilisateur u WHERE u.idUtilisateur = :idUser";
		Query query = em.createQuery(req);
		query.setParameter("idUser", idUser);
*/	
		Utilisateur u = em.find(Utilisateur.class, idUser);
		List<Trajet> listeTrajets = u.getTrajets();
		
		if (listeTrajets != null)
			return listeTrajets;
		return null;
	}



	@Override
	public List<Trajet> getTrajetsEffectuesById(int idUser) {
		
		String req = "SELECT t FROM Trajet t";
		Query query = em.createQuery(req);

		List<Trajet> listeTrajets = query.getResultList();
		System.out.println("==> taille : " + listeTrajets.size());
		
		if (listeTrajets.size() != 0)
			return listeTrajets;
		
		return null;
	}



	@Override
	public List<Trajet> getTrajetsProposesById(int idUser) {

		String req = "SELECT t FROM Trajet t";
		Query query = em.createQuery(req);

		List<Trajet> listeTrajets = query.getResultList();
		System.out.println("==> taille : " + listeTrajets.size());
		
		if (listeTrajets.size() != 0)
			return listeTrajets;
		
		return null;
	}

}
