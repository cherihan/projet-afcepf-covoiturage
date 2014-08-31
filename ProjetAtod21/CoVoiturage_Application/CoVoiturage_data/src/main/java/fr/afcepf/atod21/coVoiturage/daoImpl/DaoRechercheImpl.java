package fr.afcepf.atod21.coVoiturage.daoImpl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import fr.afcepf.atod21.coVoiturage.dao.IDaoRecherche;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.utils.Consts;

@Component
public class DaoRechercheImpl implements IDaoRecherche {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Trajet> rechercherTrajet(Date dateDepart, String villeDepart, String villeArrivee) {
/*
        String requete = "SELECT t FROM Trajet t INNER JOIN fetch t.utilisateurs "
        		+ "JOIN fetch t.avis "
        		+ "JOIN fetch t.commentaireTrajets "
        		+ "WHERE t.villeDepart.nom=:villeDepart "
                + "AND t.villeArrivee.nom=:villeArrivee AND t.dateDepart=:dateDepart "
                + "AND (t.statut=:statut1 OR t.statut=:statut2 OR t.statut=:statut3) GROUP BY t.idTrajet";
*/
        String requete = "SELECT t FROM Trajet t INNER JOIN fetch t.utilisateurs "
        		+ "WHERE t.villeDepart.nom=:villeDepart "
                + "AND t.villeArrivee.nom=:villeArrivee AND t.dateDepart=:dateDepart "
                + "AND (t.statut=:statut1 OR t.statut=:statut2 OR t.statut=:statut3) GROUP BY t.idTrajet";

        javax.persistence.Query query = em.createQuery(requete);
        query.setParameter("dateDepart", dateDepart);
        query.setParameter("villeDepart", villeDepart);
        query.setParameter("villeArrivee", villeArrivee);
        query.setParameter("statut1", Consts.PROPOSE);
        query.setParameter("statut2", Consts.EN_COURS);
        query.setParameter("statut3", Consts.COMPLET);

        List<Trajet> listResults = query.getResultList();

        return listResults;
    }

    @Override
    public List<Trajet> rechercherTrajetParVilleDepart(Date dateDepart, String villeDepart) {

        

        String requete = "SELECT t FROM Trajet t INNER JOIN fetch t.utilisateurs "
                + "WHERE t.villeDepart.nom=:villeDepart "
                + "AND t.dateDepart=:dateDepart "
                + "AND (t.statut=:statut1 OR t.statut=:statut2 OR t.statut=:statut3) GROUP BY t.idTrajet";

        javax.persistence.Query query = em.createQuery(requete);
        query.setParameter("dateDepart", dateDepart);
        query.setParameter("villeDepart", villeDepart);
        query.setParameter("statut1", Consts.PROPOSE);
        query.setParameter("statut2", Consts.EN_COURS);
        query.setParameter("statut3", Consts.COMPLET);

        List<Trajet> listResults = query.getResultList();

        return listResults;
    }


}
