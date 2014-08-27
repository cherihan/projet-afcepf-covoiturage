package fr.afcepf.atod21.coVoiturage.businessImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.atod21.coVoiturage.business.IBusinessTrajet;
import fr.afcepf.atod21.coVoiturage.business.dto.TrajetDto;
import fr.afcepf.atod21.coVoiturage.business.dto.UtilisateurDto;
import fr.afcepf.atod21.coVoiturage.dao.IDaoTrajet;
import fr.afcepf.atod21.coVoiturage.dao.IDaoUtilisateur;
import fr.afcepf.atod21.coVoiturage.daoImpl.DaoUtilisateurImpl;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;
import fr.afcepf.atod21.coVoiturage.entity.Ville;
import fr.afcepf.atod21.coVoiturage.utils.Consts;

//@Service
@Transactional
public class BusinessTrajetImpl implements IBusinessTrajet {

       
	@Autowired
	private IDaoTrajet daoTrajet;
	
	@Autowired
	private IDaoUtilisateur daoUtilisateur;

    public void setDaoTrajet(IDaoTrajet daoTrajet) {
        this.daoTrajet = daoTrajet;
    }
    
    

    @Override
    public boolean sInscrireTrajetSoap(int idTrajet, int idUser) {

        System.out.println("==============================================");
        System.out.println("id trajet = " + idTrajet);
        System.out.println("id user = " + idUser);
        System.out.println("==============================================");
        
        Trajet trajet = daoTrajet.rechercheById(idTrajet);
        
        System.out.println("==============================================");
        System.out.println("================ 1 =======================");
        System.out.println("==============================================");

        Utilisateur user = daoUtilisateur.getUserById(idUser);
        
        System.out.println("==============================================");
        System.out.println("================ 2 =======================");
        System.out.println("==============================================");

        daoTrajet.sInscrireTrajet(trajet, user);
        
        System.out.println("==============================================");
        System.out.println("================ 3 =======================");
        System.out.println("==============================================");

        TrajetDto trajetDto = new TrajetDto();

        try {
            BeanUtils.copyProperties(trajet, trajetDto);
        } catch (BeansException e) {
            System.err.println(" ERREUR : " + e.getMessage());
        }

        System.out.println("==============================================");
        System.out.println("================ 4 =======================");
        System.out.println("==============================================");
        
        trajetDto.setVilleDepart(trajet.getVilleDepart().getNom());
        trajetDto.setVilleArrivee(trajet.getVilleArrivee().getNom());

        System.out.println("==============================================");
        System.out.println("================ 5 =======================");
        System.out.println("==============================================");
        return true;
    }
    
	@Override
	public void ajouterCommentaireTrajet(int idTrajet, int idUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer creerTrajet(Trajet trajet, Utilisateur user) {

	return 	daoTrajet.creerTrajet(trajet, user);

	}

	@Override
	public void supprimerTrajet(int idTrajet, int idUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Ville> getAllVilles() {

		return daoTrajet.getAllVilles();
	}

    @Override
    public boolean sInscrireTrajet(Trajet trajet, Utilisateur user) {

        int nbPlacesDispo = trajet.getNbPassagersRestant()-1;
        
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
        // TODO Auto-generated method stub
      return true;
    }

    @Override
    public boolean annulerInscriptionTrajet(int idTrajet, int idUser) {
        return false;
    }

	
	@Override
	public List<Trajet> getAllHistoTrajets(int idUser) {
		List<Trajet> listeTrajets = daoTrajet.getAllHistoTrajets(idUser);
		return listeTrajets;
	}

    @Override
    public List<Trajet> getHistoTrajetsAsConductorByType(int idUser, String typeHistoTrajet) {
        List<Trajet> listeTrajets = daoTrajet.getHistoTrajetsAsConductorByType(idUser, typeHistoTrajet);
        return listeTrajets;
    }

    @Override
    public List<Trajet> getHistoTrajetsAsPassengerByType(int idUser, String typeHistoTrajet) {
        List<Trajet> listeTrajets = daoTrajet.getHistoTrajetsAsPassengerByType(idUser, typeHistoTrajet);
        return listeTrajets;
    }


    /**
     * @param paramDaoUtilisateur the daoUtilisateur to set
     */
    public void setDaoUtilisateur(IDaoUtilisateur paramDaoUtilisateur) {
        daoUtilisateur = paramDaoUtilisateur;
    }

   

}