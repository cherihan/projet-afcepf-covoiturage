package fr.afcepf.atod21.coVoiturage.daoImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Selection;

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
	public boolean supprimerTrajet(Trajet trajet, Utilisateur user) {
		user = em.find(Utilisateur.class, user.getIdUtilisateur());
        user.getTrajets().remove(trajet);

		//em.persist(user);
		//em.flush();

		return true;
	}
	
	public void delete(Trajet trajet) {
		Utilisateur user = em.find(Utilisateur.class, 1);
		List<Trajet> listeTrajetsBefore = user.getTrajets();
		//Trajet trajet = em.find(Trajet.class, 40);
/*
		int index = 0;
		boolean foundTrajet = false;
		Trajet t = null;
		Iterator<Trajet> iterator = listeTrajets.iterator();
		while (iterator.hasNext() && !foundTrajet) {
			t = iterator.next();
			if (t.getIdTrajet() == 40) {
				index = listeTrajets.indexOf(t);
				foundTrajet = true;
			}
		}

		/*
		em.persist(user);
		em.flush();
		*/
	}

    @Override
    public Integer creerTrajet(Trajet trajet, Utilisateur user) {

        trajet.setVilleDepart(em.find(Ville.class, trajet.getVilleDepart()
                .getIdVille()));
        trajet.setVilleArrivee(em.find(Ville.class, trajet.getVilleArrivee()
                .getIdVille()));
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
    public boolean sInscrireTrajet(Trajet trajet, Utilisateur user) {

        // user = em.find(Utilisateur.class, user.getIdUtilisateur());

        if (user != null) {

            user.getTrajets().add(trajet);

            em.persist(user);
            return true;
        }
        return false;

    }

    @Override
    public boolean seDesinscrireTrajet(Integer idTrajet, Integer idUser) {

        return false;
    }

    @Override
    public boolean annulerInscriptionTrajet(Integer idTrajet, Integer idUser) {
        // TODO Auto-generated method stub
        return false;
    }

	@Override
	public List<Ville> getAllVilles() {
		return em.createQuery("SELECT v FROM Ville v").getResultList();
	}

	@Override
	public List<Trajet> getAllHistoTrajets(int idUser) {
		
		String query = "SELECT u FROM Utilisateur u inner join fetch u.trajets WHERE u.idUtilisateur = :idUser";
		Utilisateur u = (Utilisateur) em.createQuery(query).setParameter("idUser",idUser).getSingleResult();
		return u.getTrajets();
	}

   @Override
    public List<Trajet> getHistoTrajetsByType(int idUser, String typeHistoTrajet) {
        String query = "SELECT u FROM Utilisateur u inner join fetch u.trajets WHERE u.idUtilisateur = :idUser";
        Utilisateur u = (Utilisateur) em.createQuery(query).setParameter("idUser",idUser).getSingleResult();

        List<Trajet> listeAllTrajets = u.getTrajets();

        List<Trajet> listeTrajets = new ArrayList<Trajet>();
        if(listeAllTrajets != null) {
            for (Trajet t : listeAllTrajets) {
                if (t.getStatut().equals(typeHistoTrajet) && t.getConducteurIdUser() == idUser)
                    listeTrajets.add(t);
            }
        }
        return listeTrajets;
    }


    @Override
    public Trajet rechercheById(Integer idTrajet) {

        System.out.println("==============================================");
        System.out.println("========== A ================");
        System.out.println("==============================================");

        // Trajet trajet = new Trajet();
        // trajet = em.find(Trajet.class, trajet.getIdTrajet());

        Trajet ttt = em.find(Trajet.class, idTrajet);

        System.out.println("==============================================");
        System.out.println("========== B ================");
        System.out.println("==============================================");

        if (ttt != null)
            System.out.println("=====> Trajet : " + ttt.getNbPassagersMax());
        else
            System.out.println("===== ttt est nul =========");

        // System.exit(0);
        // Utilisateur user = em.find(Utilisateur.class, idUser);

        // String requete =
        // "SELECT trajet FROM Trajet trajet WHERE trajet.id_trajet = :idTrajet";
        // List<Trajet> liste = em.createQuery(requete, Utilisateur.class)
        // .setParameter("emailUser", email)
        // .setParameter("passwordUser", password)
        // .getResultList();
        //
        // String requete =
        // "SELECT user FROM Utilisateur user WHERE user.email = :emailUser and user.password = :passwordUser";
        // List<Utilisateur> liste = em.createQuery(requete, Utilisateur.class)
        // .setParameter("emailUser", email)
        // .setParameter("passwordUser", password)
        // .getResultList();
        //

        // Trajet tt = em.find(Trajet.class, idTrajet);
        //
        // System.out.println("TRAJET DANS RECHERCHE BY ID " + tt);

        return ttt;
    }

}
