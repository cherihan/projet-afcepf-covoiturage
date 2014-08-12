package fr.afcepf.atod21.coVoiturage.businessImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.atod21.coVoiturage.business.IBusinessModerateur;
import fr.afcepf.atod21.coVoiturage.dao.IDaoModerateur;
import fr.afcepf.atod21.coVoiturage.entity.Avis;

@Service
@Transactional
public class BusinessModerateurImpl implements IBusinessModerateur {

    @Autowired
    private IDaoModerateur daoModerateur;

    @Override
    public boolean modererAvis(Avis paramAvis) {
        return false;
    }

}
