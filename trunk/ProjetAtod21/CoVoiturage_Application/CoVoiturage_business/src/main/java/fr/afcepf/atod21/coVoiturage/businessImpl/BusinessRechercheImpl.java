package fr.afcepf.atod21.coVoiturage.businessImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.atod21.coVoiturage.business.IBusinessRecherche;
import fr.afcepf.atod21.coVoiturage.dao.IDaoRecherche;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;

public class BusinessRechercheImpl implements IBusinessRecherche {

    @Autowired
    private IDaoRecherche daoRecherche;

    public void setDaoRecherche(IDaoRecherche paramDaoRecherche) {
        daoRecherche = paramDaoRecherche;
    }

    @Override
    public List<Trajet> rechercherTrajet(Date dateDepart, String villeDepart, String villeArrivee) {

        return daoRecherche.rechercherTrajet(dateDepart, villeDepart, villeArrivee);
    }

    @Override
    public List<Trajet> rechercherTrajetParVilleDepart(Date dateDepart, String villeDepart) {

        return daoRecherche.rechercherTrajetParVilleDepart(dateDepart, villeDepart);
    }


}
