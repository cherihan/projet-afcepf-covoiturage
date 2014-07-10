package fr.afcepf.atod21.coVoiturage.daoImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
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
	public void creerTrajet(Trajet trajet, Utilisateur user) {

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

	}

	@Override
	public List<Ville> getAllVilles() {

		return em.createQuery("SELECT v FROM Ville v").getResultList();
	}

}
