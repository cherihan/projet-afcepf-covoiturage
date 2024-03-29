package fr.afcepf.atod21.coVoiturage.managedBean;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.atod21.coVoiturage.business.IBusinessTrajet;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;
import fr.afcepf.atod21.coVoiturage.utils.Consts;

@ManagedBean
@SessionScoped
public class HistoTrajetMBean {

	private List<Trajet> listeHistoTrajets;
	
    private boolean afficheHistoTrajets = false;
    private boolean statutRender = false;
    private boolean restantsRender = false;
    private boolean nbParticipantsRender = false;
    
    private String typeUtilisateur;
    private Map<String,String> typeUtilisateurValues;
    {
        typeUtilisateurValues = new LinkedHashMap<String,String>();
        typeUtilisateurValues.put("Passager", Consts.PASSAGER);
        typeUtilisateurValues.put("Conducteur", Consts.CONDUCTEUR);
    }
    
    private String typeHistoTrajet;
    private Map<String,String> typeHistoTrajetValues = null;
    
	@ManagedProperty(value = "#{businessTrajetImpl}")
    private IBusinessTrajet businessTrajet;

    public String typeUserListner () {
        typeHistoTrajetValues = new LinkedHashMap<String,String>();

        typeHistoTrajetValues.clear();
        switch (typeUtilisateur) {
        case Consts.LIKE:
        case Consts.TYPE_TRAJET:
            break;
        case Consts.PASSAGER:
            typeHistoTrajetValues.put("Tous", Consts.ALL_TRAJETS);
            typeHistoTrajetValues.put("En cours", Consts.EN_COURS);
            typeHistoTrajetValues.put("Terminés", Consts.TERMINE);
            break;
        case Consts.CONDUCTEUR:
            //typeHistoTrajetValues.put("Tous", Consts.ALL_TRAJETS);
            typeHistoTrajetValues.put("En cours", Consts.EN_COURS);
            typeHistoTrajetValues.put("Terminés", Consts.TERMINE);
            typeHistoTrajetValues.put("Proposés", Consts.PROPOSE);
            break;
        default:
            break;
        }

        return "";
    }

    public String listerHistoTrajets(Utilisateur userConnected) {
        
    	statutRender = false;
    	restantsRender = false;
    	nbParticipantsRender = false;
    	
        switch (typeHistoTrajet) {
        case Consts.ALL_TRAJETS:
        	System.out.println("=====================");
        	System.out.println("==> tous les trajets :");
        	System.out.println("=====================");
        	int idUser = userConnected.getIdUtilisateur();
        	System.out.println("====> idUser : " + idUser);
        	List<Trajet> liste = businessTrajet.getAllHistoTrajets(idUser);
        	System.out.println("====> taille liste : " +liste.size());
            setListeHistoTrajets(liste);
        	System.out.println("====> setListe passed.");

        	if (!(listeHistoTrajets == null || listeHistoTrajets.size() == 0)) {
            	System.out.println("===> Liste nule.");
            	statutRender = true;
                afficheHistoTrajets = true;
            } else {
            	System.out.println("===> Liste non nule.");
                //FacesMes sage message = new FacesMessage("type user : " + typeUtilisateur + " / type trajet : " + typeHistoTrajet);
                //FacesContext.getCurrentInstance().addMessage(null, message);
            }
            break;

        default:
            setListeHistoTrajets(businessTrajet.getHistoTrajetsByType(userConnected.getIdUtilisateur(), typeHistoTrajet));
            if (!(listeHistoTrajets == null || listeHistoTrajets.size() == 0)) {
            	if (typeHistoTrajet.equals(Consts.EN_COURS) || typeHistoTrajet.equals(Consts.PROPOSE)) {
            		restantsRender = true;
            	} else if (typeHistoTrajet.equals(Consts.TERMINE)){
                	nbParticipantsRender = true;
                }
                afficheHistoTrajets = true;
            } else {
                //FacesMessage message = new FacesMessage("type user : " + typeUtilisateur + " / type trajet : " + typeHistoTrajet);
                //FacesContext.getCurrentInstance().addMessage(null, message);
            }
            break;
        }
        return "";
    }

	public String supprimer(Trajet trajet, Utilisateur user) {
		businessTrajet.supprimer(trajet, user);
		List<Trajet> liste = businessTrajet.getHistoTrajetsByType(user.getIdUtilisateur(), typeHistoTrajet);
		setListeHistoTrajets(liste);
        FacesMessage message = new FacesMessage("Votre trajet a bien été supprimé de votre historique.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        listerHistoTrajets(user);
        return "histoTrajets.xhtml";
	}
	
	public IBusinessTrajet getBusinessTrajet() {
		return businessTrajet;
	}

	public void setBusinessTrajet(IBusinessTrajet businessTrajet) {
		this.businessTrajet = businessTrajet;
	}

    public boolean isAfficheHistoTrajets() {
		return afficheHistoTrajets;
	}

	public void setAfficheHistoTrajets(boolean afficheHistoTrajets) {
		this.afficheHistoTrajets = afficheHistoTrajets;
	}

	public List<Trajet> getListeHistoTrajets() {
		return listeHistoTrajets;
	}

	public void setListeHistoTrajets(List<Trajet> listeHistoTrajets) {
		this.listeHistoTrajets = listeHistoTrajets;
	}

    public String getTypeHistoTrajet() {
        return typeHistoTrajet;
    }

    public void setTypeHistoTrajet(String paramTypeHistoTrajet) {
        typeHistoTrajet = paramTypeHistoTrajet;
    }

    public Map<String, String> getTypeHistoTrajetValues() {
        return typeHistoTrajetValues;
    }

    public void setTypeHistoTrajetValues(
            Map<String, String> paramTypeHistoTrajetValues) {
        typeHistoTrajetValues = paramTypeHistoTrajetValues;
    }

    public String getTypeUtilisateur() {
        return typeUtilisateur;
    }

    public void setTypeUtilisateur(String paramTypeUtilisateur) {
        typeUtilisateur = paramTypeUtilisateur;
    }

    public Map<String, String> getTypeUtilisateurValues() {
        return typeUtilisateurValues;
    }

    public void setTypeUtilisateurValues(
            Map<String, String> paramTypeUtilisateurValues) {
        typeUtilisateurValues = paramTypeUtilisateurValues;
    }

	public boolean isStatutRender() {
		return statutRender;
	}

	public void setStatutRender(boolean statutRender) {
		this.statutRender = statutRender;
	}

	public boolean isRestantsRender() {
		return restantsRender;
	}

	public void setRestantsRender(boolean restantsRender) {
		this.restantsRender = restantsRender;
	}

	public boolean isNbParticipantsRender() {
		return nbParticipantsRender;
	}

	public void setNbParticipantsRender(boolean nbParticipantsRender) {
		this.nbParticipantsRender = nbParticipantsRender;
	}

}
