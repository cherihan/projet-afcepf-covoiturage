package fr.afcepf.atod21.coVoiturage.businessImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.atod21.coVoiturage.business.IBusinessRecherche;
import fr.afcepf.atod21.coVoiturage.business.dto.TrajetDto;
import fr.afcepf.atod21.coVoiturage.dao.IDaoRecherche;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;

@Service
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

    @Override
    public List<TrajetDto> rechercherTrajetDto(Date paramDateDepart, String paramVilleDepart, String paramVilleArrivee) {
        List<Trajet> listeTrajets = daoRecherche.rechercherTrajet(paramDateDepart, paramVilleDepart, paramVilleArrivee);

        if (listeTrajets == null)
            return null;
        
        List<TrajetDto> listeTrajetsDto = new ArrayList<TrajetDto>();
        
        TrajetDto trajetDto = null;
        
        for (Trajet trajet : listeTrajets) {
            
            trajetDto = new TrajetDto();
            BeanUtils.copyProperties(trajet, trajetDto);
            trajetDto.setDateCreationDto(trajet.getDateCreation().toString());
            trajetDto.setDateDepartDto(trajet.getDateDepart().toString());
            trajetDto.setVilleDepartDto(trajet.getVilleDepart().getNom());
            trajetDto.setVilleArriveeDto(trajet.getVilleArrivee().getNom());
            
            /*
            List<AvisDto> listeAvisDto = new ArrayList<AvisDto>();
            AvisDto avisDto = new AvisDto();
            List<Avis> listeAvis = trajet.getAvis();

            if (listeAvis != null) {
                for (Avis avis : trajet.getAvis()) {
                    BeanUtils.copyProperties(avis, avisDto);
                    listeAvisDto.add(avisDto);
                }

                trajetDto.setListeAvisDto(listeAvisDto);
            }
            */
            
            /*
            List<CommentaireTrajetDto> listeCommentaireTrajetDto = new ArrayList<CommentaireTrajetDto>();
            CommentaireTrajetDto commentaireTrajetDto = new CommentaireTrajetDto();
            if (listeCommentaireTrajetDto != null) {
                for (CommentaireTrajet commentaireTrajet : trajet.getCommentaireTrajets()) {
                    BeanUtils.copyProperties(commentaireTrajet, commentaireTrajetDto);
                    listeCommentaireTrajetDto.add(commentaireTrajetDto);
                }

                trajetDto.setListeCommentairesDto(listeCommentaireTrajetDto);
            }
            */

            listeTrajetsDto.add(trajetDto);
        }

        return listeTrajetsDto;
    }

    @Override
    public List<TrajetDto> rechercherTrajetParVilleDepartDto(Date paramDateDepart, String paramVilleDepart) {
        
         List<Trajet> listeTrajets = daoRecherche.rechercherTrajetParVilleDepart(paramDateDepart, paramVilleDepart);

        if (listeTrajets == null)
            return null;
        
        List<TrajetDto> listeTrajetsDto = new ArrayList<TrajetDto>();
        
        TrajetDto trajetDto = null;
        
        for (Trajet trajet : listeTrajets) {
            
            trajetDto = new TrajetDto();
            BeanUtils.copyProperties(trajet, trajetDto);
            trajetDto.setDateCreationDto(trajet.getDateCreation().toString());
            trajetDto.setDateDepartDto(trajet.getDateDepart().toString());
            trajetDto.setVilleDepartDto(trajet.getVilleDepart().getNom());
            trajetDto.setVilleArriveeDto(trajet.getVilleArrivee().getNom());
            listeTrajetsDto.add(trajetDto);
        }

            return listeTrajetsDto;
    }


}
