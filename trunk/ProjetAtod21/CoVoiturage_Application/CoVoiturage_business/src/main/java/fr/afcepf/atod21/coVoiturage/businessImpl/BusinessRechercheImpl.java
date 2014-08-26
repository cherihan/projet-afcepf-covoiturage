package fr.afcepf.atod21.coVoiturage.businessImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.atod21.coVoiturage.business.IBusinessRecherche;
import fr.afcepf.atod21.coVoiturage.business.dto.TrajetDto;
import fr.afcepf.atod21.coVoiturage.dao.IDaoRecherche;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;

public class BusinessRechercheImpl implements IBusinessRecherche {

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

    @Override
    public List<TrajetDto> rechercherTrajetSOAP(Date paramDateDepart, String paramVilleDepart, String paramVilleArrivee) {
        List<Trajet> listeTrajets = new ArrayList<Trajet>();
        List<TrajetDto> listeTrajetsDto = null;
        
        listeTrajets = daoRecherche.rechercherTrajet(paramDateDepart, paramVilleDepart, paramVilleArrivee);
        
        //TODO remplissage de listeTrajetsDto
    
        return listeTrajetsDto;
    }

    @Override
    public List<TrajetDto> rechercherTrajetParVilleDepartSOAP(Date paramDateDepart, String paramVilleDepart) {
        List<Trajet> listeTrajets = new ArrayList<Trajet>();
        List<TrajetDto> listeTrajetsDto = null;
        
        listeTrajets = daoRecherche.rechercherTrajetParVilleDepart(paramDateDepart, paramVilleDepart);

        //TODO remplissage de listeTrajetsDto

        return listeTrajetsDto;
    }


}
