package fr.afcepf.atod21.coVoiturage.businessImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.atod21.coVoiturage.business.IBusinessUtilisateur;
import fr.afcepf.atod21.coVoiturage.dao.IDaoUtilisateur;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;

@Service
@Transactional
public class BusinessUtilisateurImpl implements IBusinessUtilisateur {

    @Autowired
    private IDaoUtilisateur daoUtilisateur;

    public void setDaoUtilisateur(IDaoUtilisateur paramDaoUtilisateur) {
        daoUtilisateur = paramDaoUtilisateur;
    }

    @Override
    public void afficher() {
        daoUtilisateur.afficher();
    }

    @Override
    public void changerPassword(Utilisateur utilisateur) {
        // TODO Auto-generated method stub

    }

    @Override
    public Integer creerCompte(Utilisateur user) {
        return daoUtilisateur.creerCompte(user);
    }

    @Override
    public Utilisateur getUserById(Integer idUser) {

        return daoUtilisateur.getUserById(idUser);
    }

}
