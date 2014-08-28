package fr.afcepf.atod21.coVoiturage.businessImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.atod21.coVoiturage.business.IBusinessConnexion;
import fr.afcepf.atod21.coVoiturage.business.dto.UtilisateurDto;
import fr.afcepf.atod21.coVoiturage.dao.IDaoConnexion;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;

@Service
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
        
        if (user != null) {
            UtilisateurDto userDto = new UtilisateurDto();
            BeanUtils.copyProperties(user, userDto);
            
            userDto.setNumeroAdresse(user.getAdresse().getNumero());
            userDto.setTypeVoieAdresse(user.getAdresse().getTypeVoie());
            userDto.setNomVoieAdresse(user.getAdresse().getNomVoie());
            userDto.setNomVille(user.getAdresse().getVille().getNom());
            userDto.setCodePostalVille(user.getAdresse().getVille().getCodePostal());
            userDto.setPaysVille(user.getAdresse().getVille().getPays());
            return userDto;
        }
        return null;        
    }

    @Override
    public void seDeconnecter(Utilisateur utilisateur) {
        // TODO Auto-generated method stub

    }


}
