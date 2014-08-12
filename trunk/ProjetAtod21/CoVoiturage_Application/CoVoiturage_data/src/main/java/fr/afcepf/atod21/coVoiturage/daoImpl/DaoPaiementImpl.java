package fr.afcepf.atod21.coVoiturage.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.atod21.coVoiturage.dao.IDaoPaiement;

@Component
@Transactional
public class DaoPaiementImpl implements IDaoPaiement {

    public DaoPaiementImpl() {
    }

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean paiement(int paramIdCarte) {
        return false;
    }

}
