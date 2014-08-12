package fr.afcepf.atod21.coVoiturage.managedBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.atod21.coVoiturage.business.IBusinessTrajet;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;
import fr.afcepf.atod21.coVoiturage.utils.Consts;

@ManagedBean
@SessionScoped
public class HistoTrajetMBean {

	private List<Trajet> listeHistoTrajets;
	private List<Trajet> listeTrajetsEffectues;
	private List<Trajet> listeTrajetsEnCours;
	private List<Trajet> listeTrajetsProposes;
    private boolean activeHistoEnCours = false;
    private boolean activeHistoTermines = false;
    private boolean activeHistoProposes = false;
    private boolean activeHistoAll = false;
    private boolean afficheHistoTrajets = false;
    
	@ManagedProperty(value = "#{businessTrajetImpl}")
	private IBusinessTrajet businessTrajet;

   public String histoAllTrajets(Utilisateur user) {

        setListeHistoTrajets(businessTrajet.getAllHistoTrajets(user.getIdUtilisateur()));
        this.activeHistoEnCours = false;
        this.activeHistoTermines = false;
        this.activeHistoProposes = false;
        this.activeHistoAll = true;
        this.afficheHistoTrajets = true;

        return "";
    }
   
	public String histoTrajetsByType(Utilisateur user, String typeHistoTrajet) {

		setListeHistoTrajets(businessTrajet.getHistoTrajetsByType(user.getIdUtilisateur(), typeHistoTrajet));
	    this.activeHistoEnCours = false;
	    this.activeHistoTermines = false;
        this.activeHistoProposes = false;
        this.activeHistoAll = false;
		this.afficheHistoTrajets = true;

		switch (typeHistoTrajet) {
    		case Consts.EN_COURS :
    		    this.activeHistoEnCours = true;
    			break;
    			
    		case Consts.TERMINE :
    		    this.activeHistoTermines = true;
    			break;
    
    		case Consts.PROPOSE :
    		    this.activeHistoProposes = true;
    		    System.out.println("===> je suis dans le case PROPOSE.");
    		    System.out.println("===> typeHistoTrajt = " + typeHistoTrajet);
    		    break;
    			
    		default:
    			break;
		}
		return "";
	}

	public String consulterTrajet(int idTrajet) {

		return "";
	}

	public String supprimerTrajet(int idTrajet) {

		return "";
	}

	public IBusinessTrajet getBusinessTrajet() {
		return businessTrajet;
	}

	public void setBusinessTrajet(IBusinessTrajet businessTrajet) {
		this.businessTrajet = businessTrajet;
	}

	public List<Trajet> getListeTrajetsEffectues() {
		return listeTrajetsEffectues;
	}

	public void setListeTrajetsEffectues(List<Trajet> listeTrajetsEffectues) {
		this.listeTrajetsEffectues = listeTrajetsEffectues;
	}

	public List<Trajet> getListeTrajetsEnCours() {
		return listeTrajetsEnCours;
	}

	public void setListeTrajetsEnCours(List<Trajet> listeTrajetsEnCours) {
		this.listeTrajetsEnCours = listeTrajetsEnCours;
	}

	public List<Trajet> getListeTrajetsProposes() {
		return listeTrajetsProposes;
	}

	public void setListeTrajetsProposes(List<Trajet> listeTrajetsProposes) {
		this.listeTrajetsProposes = listeTrajetsProposes;
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

    /**
     * @return the activeHistoEnCours
     */
    public boolean isActiveHistoEnCours() {
        return activeHistoEnCours;
    }

    /**
     * @param paramActiveHistoEnCours the activeHistoEnCours to set
     */
    public void setActiveHistoEnCours(boolean paramActiveHistoEnCours) {
        activeHistoEnCours = paramActiveHistoEnCours;
    }

    /**
     * @return the activeHistoProposes
     */
    public boolean isActiveHistoProposes() {
        return activeHistoProposes;
    }

    /**
     * @param paramActiveHistoProposes the activeHistoProposes to set
     */
    public void setActiveHistoProposes(boolean paramActiveHistoProposes) {
        activeHistoProposes = paramActiveHistoProposes;
    }

    /**
     * @return the activeHistoTermines
     */
    public boolean isActiveHistoTermines() {
        return activeHistoTermines;
    }

    /**
     * @param paramActiveHistoTermines the activeHistoTermines to set
     */
    public void setActiveHistoTermines(boolean paramActiveHistoTermines) {
        activeHistoTermines = paramActiveHistoTermines;
    }

    /**
     * @return the activeHistoAll
     */
    public boolean isActiveHistoAll() {
        return activeHistoAll;
    }

    /**
     * @param paramActiveHistoAll the activeHistoAll to set
     */
    public void setActiveHistoAll(boolean paramActiveHistoAll) {
        activeHistoAll = paramActiveHistoAll;
    }

}
