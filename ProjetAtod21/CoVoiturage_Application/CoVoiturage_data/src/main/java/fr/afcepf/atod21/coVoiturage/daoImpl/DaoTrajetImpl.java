package fr.afcepf.atod21.coVoiturage.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	public boolean supprimer(Trajet trajet, Utilisateur user) {
		user = em.find(Utilisateur.class, user.getIdUtilisateur());
		ListIterator<Trajet> li = user.getTrajets().listIterator();
		while(li.hasNext()) {
			Trajet t= li.next();
			if (trajet.getIdTrajet() == t.getIdTrajet())
				li.remove();
		}
		em.merge(user);
		return true;
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

         user = em.find(Utilisateur.class, user.getIdUtilisateur());
         System.out.println("==================== avant merge :" + trajet);
        if (user != null) {
            List<Trajet> tra = user.getTrajets();
        	System.out.println("==================== taille  avant :" + tra.size());
        	System.out.println("==================== places dispo:" + trajet.getIdTrajet() + " / " + trajet.getNbPassagersRestant());
            tra.add(trajet);
            System.out.println("==================== taille  apres :" + tra.size());
            em.merge(user);
            em.merge(trajet);
            Utilisateur user_ = em.find(Utilisateur.class, user.getIdUtilisateur());
            Trajet trajet_ = em.find(Trajet.class, trajet.getIdTrajet());
            System.out.println("==================== apres merge :" + user_.getTrajets().size());
            System.out.println("==================== apres merge :" + trajet_);
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
    	System.out.println("===> Dao.");
		String query = "SELECT u FROM Utilisateur u inner join fetch u.trajets WHERE u.idUtilisateur = :idUser";
		Utilisateur u = (Utilisateur) em.createQuery(query).setParameter("idUser",idUser).getSingleResult();
    	System.out.println("===> taille : " + u.getTrajets().size());

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
