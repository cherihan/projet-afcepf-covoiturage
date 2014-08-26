package fr.afcepf.atod21.coVoiturage.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import  fr.afcepf.atod21.coVoiturage.dao.IDaoConnexion;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;

@Component
@Transactional
public class DaoConnexionImpl implements IDaoConnexion {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Utilisateur seConnecter(String email, String password) {
        String requete = "SELECT user FROM Utilisateur user WHERE user.email = :emailUser and user.password = :passwordUser";
        List<Utilisateur> liste = em.createQuery(requete, Utilisateur.class)
                                    .setParameter("emailUser", email)
                                    .setParameter("passwordUser", password)
                                    .getResultList();
        if (liste.size() != 0)
            return liste.get(0);
        return null;
    }

    @Override
    public void seDeconnecter(Utilisateur utilisateur) {
        // TODO Auto-generated method stub
        
    }

}
