package fr.afcepf.atod21.coVoiturage.managedBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.afcepf.atod21.coVoiturage.business.IBusinessTrajet;
import fr.afcepf.atod21.coVoiturage.business.IBusinessUtilisateur;
import fr.afcepf.atod21.coVoiturage.common.Common;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;
import fr.afcepf.atod21.coVoiturage.entity.Ville;
import fr.afcepf.atod21.coVoiturage.utils.Consts;

@ManagedBean
@SessionScoped
public class TrajetMBean {

    private Trajet trajet = new Trajet();
    private String dateDepart;
    private String nbPassagersSelected;
    private Ville villeDepart = new Ville();
    private Ville villeArrivee = new Ville();
    private List<Ville> listVilles = new ArrayList<Ville>();
    private List<String> listNomVilles = new ArrayList<String>();
    private Map<String, Ville> mapVilles = new HashMap<String, Ville>();
    private boolean inscrit;

    @ManagedProperty(value = "#{businessTrajetImpl}")
    private IBusinessTrajet businessTrajet;

    @ManagedProperty(value = "#{businessUtilisateurImpl}")
    private IBusinessUtilisateur businessUtilisateur;

    @PostConstruct
    public void init() {
        this.listVilles = businessTrajet.getAllVilles();
        for (Ville v : this.listVilles) {
            mapVilles.put(v.getNom(), v);
            this.listNomVilles.add(v.getNom());
        }
    }
    
    public String consulterTrajet(Trajet trajet) {
        System.out.println("Je passe bien dans la méthode consulterTrajet");
        System.out.println(trajet.getIdTrajet());
        this.trajet = trajet;
        return "detailTrajet.xhtml?faces-redirect=true";
    }
    
	public String sInscrireTrajet(Trajet trajet, Utilisateur user) {
		try {
			List<Trajet> listTrajets = user.getTrajets();
			inscrit = false;
			
			for (Trajet t : listTrajets) {
				if(t.getIdTrajet() == trajet.getIdTrajet())
					inscrit = true;
			}
//			System.out.println("ksjqdhqslkjdhqksljhdqs ===================================" + trajet.getIdTrajet());
			if(inscrit){
				FacesMessage message = new FacesMessage("Vous etes déja inscrit");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return "";
			} else {
				FacesMessage message = new FacesMessage("Votre demande d'inscription à  ce trajet a bien été enregistrée !");
				FacesContext.getCurrentInstance().addMessage(null, message);
			    businessTrajet.sInscrireTrajet(trajet, user);
			    user.getTrajets().add(trajet);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.trajet = trajet;
		return "detailTrajet.xhtml?faces-redirect=false";
	}
    
    public String creerTrajet(Utilisateur userEnSession) {
        String redirection = "success";
        this.villeDepart = this.mapVilles.get(this.villeDepart.getNom());
        this.villeArrivee = this.mapVilles.get(this.villeArrivee.getNom());
        Date dateDepart = Common.convertDate(this.dateDepart);
        int nbPassagersMax = Integer.parseInt(this.nbPassagersSelected);
        Trajet trajetToInsert = new Trajet(new Date(), userEnSession.getIdUtilisateur(), dateDepart, villeDepart,
                                            villeArrivee, nbPassagersMax, nbPassagersMax, trajet.getTarif(),"En cours");
        Integer idTrajet = businessTrajet.creerTrajet(trajetToInsert, userEnSession);
        FacesMessage message = new FacesMessage("Votre trajet a été crée avec succès !");
        FacesContext.getCurrentInstance().addMessage(null, message);
        if (idTrajet == null) {
            redirection = "error";
        }
        clearFormUtilisateur();
        this.trajet = trajetToInsert;
        //return redirection;
        return "detailTrajet.xhtml?faces-redirect=false";
    }

    public String annuler() {
        clearFormUtilisateur();
        return "cancel";
    }

    private void clearFormUtilisateur() {
        HttpSession session = ((HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest())
                .getSession();
        UtilisateurMBean utilisateurBean = (UtilisateurMBean) session.getAttribute("utilisateurMBean");
        utilisateurBean.setDateDepart("");
        utilisateurBean.setVilleDepart(null);
        utilisateurBean.setVilleArrivee(null);
    }

    public String supprimerTrajet() {
        return "";
    }

    public String ajouterCommentaireTrajet() {
        return "";
    }

    public IBusinessTrajet getBusinessTrajet() {
        return businessTrajet;
    }

    public void setBusinessTrajet(IBusinessTrajet businessTrajet) {
        this.businessTrajet = businessTrajet;
    }

    public Trajet getTrajet() {
        return trajet;
    }

    public void setTrajet(Trajet trajet) {
        this.trajet = trajet;
    }

    public String getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(String dateDepart) {
        this.dateDepart = dateDepart;
    }

    public String getNbPassagersSelected() {
        return nbPassagersSelected;
    }

    public void setNbPassagersSelected(String nbPassagersSelected) {
        this.nbPassagersSelected = nbPassagersSelected;
    }

    public List<Ville> getListVilles() {
        return listVilles;
    }

    public void setListVilles(List<Ville> listVilles) {
        this.listVilles = listVilles;
    }

    public Map<String, Ville> getMapVilles() {
        return mapVilles;
    }

    public void setMapVilles(Map<String, Ville> mapVilles) {
        this.mapVilles = mapVilles;
    }

    public Ville getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(Ville villeDepart) {
        this.villeDepart = villeDepart;
    }

    public Ville getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(Ville villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public List<String> getListNomVilles() {
        return listNomVilles;
    }

    public void setListNomVilles(List<String> listNomVilles) {
        this.listNomVilles = listNomVilles;
    }

    public IBusinessUtilisateur getBusinessUtilisateur() {
        return businessUtilisateur;
    }

    public void setBusinessUtilisateur(IBusinessUtilisateur businessUtilisateur) {
        this.businessUtilisateur = businessUtilisateur;
    }

	public boolean isInscrit() {
		return inscrit;
	}

	public void setInscrit(boolean inscrit) {
		this.inscrit = inscrit;
	}

	

}
