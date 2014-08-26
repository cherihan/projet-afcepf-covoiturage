package fr.afcepf.atod21.coVoiturage.businessImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.atod21.coVoiturage.business.IBusinessConnexion;
import fr.afcepf.atod21.coVoiturage.business.dto.UtilisateurDto;
import fr.afcepf.atod21.coVoiturage.dao.IDaoConnexion;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;

public class BusinessConnexionImpl implements IBusinessConnexion {

    @Autowired
    private IDaoConnexion daoConnexion;
   
    public void setDaoConnexion(IDaoConnexion paramDaoConnexion) {
        daoConnexion = paramDaoConnexion;
    }

    @Override
    public Utilisateur seConnecter(String email, String password) {

        return daoConnexion.seConnecter(email, password);
        
    }

    @Override
    public UtilisateurDto seConnecterSOAP(String email, String password) {

        Utilisateur user = daoConnexion.seConnecter(email, password);
        UtilisateurDto userDto = new UtilisateurDto();
        BeanUtils.copyProperties(user, userDto);
        
        userDto.setNumeroAdresse(user.getAdresse().getNumero());
        userDto.setTypeVoieAdresse(user.getAdresse().getTypeVoie());
        userDto.setNomVoieAdresse(user.getAdresse().getNomVoie());
        userDto.setNomVille(user.getAdresse().getVille().getNom());
        userDto.setCodePostalVille(user.getAdresse().getVille().getCodePostal());
        userDto.setPaysVille(user.getAdresse().getVille().getPays());
        //userDto.setPorteurCarte(user.getCartes().get(0).getPorteur());
        //userDto.setNumCarte(user.getCartes().get(0).getNumCarte());
        //userDto.setCryptogrammeCarte(user.getCartes().get(0).getCryptogramme());
        //userDto.setDateExpirationCarte(user.getCartes().get(0).getDateExpiration());
        
        System.out.println("===> user DTO : " + userDto);
        
        return userDto;
    }

    @Override
    public void seDeconnecter(Utilisateur utilisateur) {
        // TODO Auto-generated method stub

    }


}
