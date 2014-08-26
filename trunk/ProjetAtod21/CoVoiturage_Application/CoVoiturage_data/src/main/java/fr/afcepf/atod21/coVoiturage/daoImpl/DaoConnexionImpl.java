package fr.afcepf.atod21.coVoiturage.daoImpl;

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
    public Utilisateur seConnecter(String paramEmail, String paramPassword) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void seDeconnecter(Utilisateur paramUtilisateur) {
        // TODO Auto-generated method stub
        
    }

}
