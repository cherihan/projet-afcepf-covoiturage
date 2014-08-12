package fr.afcepf.atod21.coVoiturage.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.atod21.coVoiturage.dao.IDaoModerateur;
import fr.afcepf.atod21.coVoiturage.entity.Avis;

@Component
@Transactional
public class DaoModerateurImpl implements IDaoModerateur {

    public DaoModerateurImpl() {
    }

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public boolean modererAvis(Avis paramAvis) {
        // TODO Auto-generated method stub
        return false;
    }

}
