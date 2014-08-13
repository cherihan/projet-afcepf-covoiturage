package fr.afcepf.atod21.coVoiturage.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.atod21.coVoiturage.dao.IDaoTrajet;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;
import fr.afcepf.atod21.coVoiturage.entity.Ville;
import fr.afcepf.atod21.coVoiturage.utils.Consts;

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
	    
		trajet.setVilleDepart(em.find(Ville.class, trajet.getVilleDepart().getIdVille()));
		trajet.setVilleArrivee(em.find(Ville.class, trajet.getVilleArrivee().getIdVille()));
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
	public List<Trajet> getAllHistoTrajets(int idUser) {
		
		String query = "SELECT u FROM Utilisateur u inner join fetch u.trajets WHERE u.idUtilisateur = :idUser";
		Utilisateur u = (Utilisateur) em.createQuery(query).setParameter("idUser",idUser).getSingleResult();
		System.out.println("===> taille = " + u.getTrajets().size());
		return u.getTrajets();
	}

   @Override
    public List<Trajet> getHistoTrajetsAsConductorByType(int idUser, String typeHistoTrajet) {
        
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
   public List<Trajet> getHistoTrajetsAsPassengerByType(int idUser, String typeHistoTrajet) {
       
       String query = "SELECT u FROM Utilisateur u inner join fetch u.trajets WHERE u.idUtilisateur = :idUser";
       Utilisateur u = (Utilisateur) em.createQuery(query).setParameter("idUser",idUser).getSingleResult();

       List<Trajet> listeAllTrajets = u.getTrajets();

       List<Trajet> listeTrajets = new ArrayList<Trajet>();
       if(listeAllTrajets != null) {
           for (Trajet t : listeAllTrajets) {
               if (t.getStatut().equals(typeHistoTrajet) && t.getConducteurIdUser() != idUser)
                   listeTrajets.add(t);
           }
       }
       return listeTrajets;
   }

}
