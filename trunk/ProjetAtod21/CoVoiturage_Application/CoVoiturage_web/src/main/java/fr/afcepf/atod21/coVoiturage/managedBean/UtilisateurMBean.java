package fr.afcepf.atod21.coVoiturage.managedBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;

import fr.afcepf.atod21.coVoiturage.business.IBusinessConnexion;
import fr.afcepf.atod21.coVoiturage.business.IBusinessRecherche;
import fr.afcepf.atod21.coVoiturage.business.IBusinessTrajet;
import fr.afcepf.atod21.coVoiturage.business.IBusinessUtilisateur;
import fr.afcepf.atod21.coVoiturage.common.Common;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;

@ManagedBean
@SessionScoped
public class UtilisateurMBean {

    @ManagedProperty(value = "#{businessUtilisateurImpl}")
    private IBusinessUtilisateur businessUtilisateur;

    @ManagedProperty(value = "#{businessRechercheImpl}")
    private IBusinessRecherche businessRecherche;

    @ManagedProperty(value = "#{businessTrajetImpl}")
    private IBusinessTrajet businessTrajet;
   
	private Utilisateur user;
	private Trajet trajet = new Trajet();

	private String email;
	private String password;
	private String villeDepart;
	private String villeArrivee;
	private String dateDepart;
	private boolean displayTableResultsTrajets = false;
	private HtmlDataTable dataTableTrajets = new HtmlDataTable();

	private List<Trajet> listResults = new ArrayList<Trajet>();
	
	

	@PostConstruct
	public void init() {

	}

	public String sInscrireTrajet(Trajet trajet, Utilisateur user) {
//		try {
//			System.out.println("ksjqdhqslkjdhqksljhdqs ===================================" + trajet.getIdTrajet());
////			FacesMessage message = new FacesMessage(
////					"Votre demande d'inscription à  ce trajet a bien été enregistrée !");
////			FacesContext.getCurrentInstance().addMessage(null, message);
////		    businessTrajet.sInscrireTrajet(trajet, user);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
			this.trajet = trajet;
		return "detailTrajet.xhtml?faces-redirect=false";
	}

	public String seDesincrireTrajet() {
		// TODO
		return "";
	}

	public String annulerInscriptionTrajet() {
		// TODO
		return "";
	}

	public String rechercherTrajet() {
		String retour = "listerTrajets.xhtml?faces-redirect=true";
		Date dateDeDepart = Common.convertDate(this.dateDepart);
		if (this.villeArrivee == null || this.villeArrivee.trim().length() == 0) {
			this.listResults = this.businessRecherche.rechercherTrajetParVilleDepart(dateDeDepart, villeDepart);
		} else {
			this.listResults = this.businessRecherche.rechercherTrajet(dateDeDepart, this.villeDepart, this.villeArrivee);
		}

		if (listResults != null) {
			this.displayTableResultsTrajets = true;
		}

		if (listResults.size() == 0 || listResults == null) {
			FacesMessage message = new FacesMessage("Aucun resultat disponible !");
			FacesContext.getCurrentInstance().addMessage(null, message);
			this.displayTableResultsTrajets = false;
			retour = "";
		}
		return retour;
	}

   public Utilisateur getUserById(int idUser) {
       return this.businessUtilisateur.getUserById(idUser);
    }

	public String motDepasseOublie() {
		// TODO
		return "";
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public Trajet getTrajet() {
		return trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

	public IBusinessUtilisateur getBusinessUtilisateur() {
		return businessUtilisateur;
	}

	public void setBusinessUtilisateur(IBusinessUtilisateur businessUtilisateur) {
		this.businessUtilisateur = businessUtilisateur;
	}

	
	/**
     * @return the businessRecherche
     */
    public IBusinessRecherche getBusinessRecherche() {
        return businessRecherche;
    }

    /**
     * @param paramBusinessRecherche the businessRecherche to set
     */
    public void setBusinessRecherche(IBusinessRecherche paramBusinessRecherche) {
        businessRecherche = paramBusinessRecherche;
    }

    /**
     * @return the businessTrajet
     */
    public IBusinessTrajet getBusinessTrajet() {
        return businessTrajet;
    }

    /**
     * @param paramBusinessTrajet the businessTrajet to set
     */
    public void setBusinessTrajet(IBusinessTrajet paramBusinessTrajet) {
        businessTrajet = paramBusinessTrajet;
    }

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}

	public String getVilleArrivee() {
		return villeArrivee;
	}

	public void setVilleArrivee(String villeArrivee) {
		this.villeArrivee = villeArrivee;
	}

	public String getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}

	public boolean isDisplayTableResultsTrajets() {
		return displayTableResultsTrajets;
	}

	public void setDisplayTableResultsTrajets(boolean displayTableResultsTrajets) {
		this.displayTableResultsTrajets = displayTableResultsTrajets;
	}

	public List<Trajet> getListResults() {
		return listResults;
	}

	public void setListResults(List<Trajet> listResults) {
		this.listResults = listResults;
	}

	public HtmlDataTable getDataTableTrajets() {
		return dataTableTrajets;
	}

	public void setDataTableTrajets(HtmlDataTable dataTableTrajets) {
		this.dataTableTrajets = dataTableTrajets;
	}
}
