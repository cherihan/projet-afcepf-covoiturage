package fr.afcepf.atod21.coVoiturage.businessImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.atod21.coVoiturage.business.IBusinessPaiement;
import fr.afcepf.atod21.coVoiturage.dao.IDaoPaiement;

@Service
@Transactional
public class BusinessPaiementImpl implements IBusinessPaiement {

    @Autowired
    private IDaoPaiement daoPaiement;
    
    @Override
    public boolean paiement(int paramIdCarte) {
        return false;
    }

}
