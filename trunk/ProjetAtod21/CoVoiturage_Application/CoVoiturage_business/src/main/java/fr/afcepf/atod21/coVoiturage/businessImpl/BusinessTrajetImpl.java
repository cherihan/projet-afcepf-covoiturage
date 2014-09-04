package fr.afcepf.atod21.coVoiturage.businessImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.atod21.coVoiturage.business.IBusinessTrajet;
import fr.afcepf.atod21.coVoiturage.business.dto.TrajetDto;
import fr.afcepf.atod21.coVoiturage.dao.IDaoTrajet;
import fr.afcepf.atod21.coVoiturage.dao.IDaoUtilisateur;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;
import fr.afcepf.atod21.coVoiturage.entity.Ville;
import fr.afcepf.atod21.coVoiturage.utils.Consts;

@Service
@Transactional
public class BusinessTrajetImpl implements IBusinessTrajet {

    @Autowired
    private IDaoTrajet daoTrajet;

    @Autowired
    private IDaoUtilisateur daoUtilisateur;

    public void setDaoTrajet(IDaoTrajet daoTrajet) {
        this.daoTrajet = daoTrajet;
    }

    public void setDaoUtilisateur(IDaoUtilisateur paramDaoUtilisateur) {
        daoUtilisateur = paramDaoUtilisateur;
    }
    
    @Override
    public boolean sInscrireTrajetSoap(int idTrajet, int idUser) {

        Trajet trajet = daoTrajet.rechercheById(idTrajet);

        Utilisateur user = daoUtilisateur.getUserById(idUser);

        daoTrajet.sInscrireTrajet(trajet, user);

        TrajetDto trajetDto = new TrajetDto();

        try {
            BeanUtils.copyProperties(trajet, trajetDto);
        } catch (BeansException e) {
            System.err.println(" ERREUR : " + e.getMessage());
        }

        trajetDto.setVilleDepartDto(trajet.getVilleDepart().getNom());
        trajetDto.setVilleArriveeDto(trajet.getVilleArrivee().getNom());

        return true;
    }

    @Override
    public Integer creerTrajet(Trajet trajet, Utilisateur user) {

        return daoTrajet.creerTrajet(trajet, user);

    }
    
    @Override
    public void ajouterCommentaireTrajet(int idTrajet, int idUser) {
        // TODO Auto-generated method stub

    }


	@Override
	public boolean supprimer(Trajet trajet, Utilisateur user) {
		return daoTrajet.supprimer(trajet, user);
	}

    @Override
    public List<Ville> getAllVilles() {

        return daoTrajet.getAllVilles();
    }

    @Override
    public boolean sInscrireTrajet(Trajet trajet, Utilisateur user) {

        int nbPlacesDispo = trajet.getNbPassagersRestant() - 1;

        if (nbPlacesDispo == 0) {
            trajet.setStatut(Consts.COMPLET);
        } else if (nbPlacesDispo > 0) {
            trajet.setStatut(Consts.EN_COURS);
        }
        trajet.setNbPassagersRestant(nbPlacesDispo);
        daoTrajet.sInscrireTrajet(trajet, user);
        return true;
    }

    @Override
    public boolean seDesinscrireTrajet(int idTrajet, int idUser) {
        return false;
    }

    @Override
    public boolean annulerInscriptionTrajet(int idTrajet, int idUser) {
        return false;
    }

    @Override
    public List<Trajet> getAllHistoTrajets(int idUser) {
    	System.out.println("===> Business.");
        List<Trajet> listeTrajets = daoTrajet.getAllHistoTrajets(idUser);
        return listeTrajets;
    }

    @Override
    public List<Trajet> getHistoTrajetsByType(int idUser, String typeHistoTrajet) {
        List<Trajet> listeTrajets = daoTrajet.getHistoTrajetsByType(idUser, typeHistoTrajet);
        return listeTrajets;
    }

}