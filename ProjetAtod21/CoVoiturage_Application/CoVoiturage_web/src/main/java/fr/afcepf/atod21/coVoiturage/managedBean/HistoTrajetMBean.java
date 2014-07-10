package fr.afcepf.atod21.coVoiturage.managedBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.atod21.coVoiturage.business.IBusinessTrajet;
import fr.afcepf.atod21.coVoiturage.entity.Trajet;
import fr.afcepf.atod21.coVoiturage.entity.Utilisateur;

@ManagedBean
@SessionScoped
public class HistoTrajetMBean {

	private List<Trajet> listeTrajetsEffectues;
	private List<Trajet> listeTrajetsEnCours;
	private List<Trajet> listeTrajetsProposes;
	private String typeHistoTrajet;
	private boolean afficheHistoTrajets = false;
	
	@ManagedProperty (value="#{businessTrajetImpl}")
	private IBusinessTrajet businessTrajet;

	public String trajetsEnCours(Utilisateur user) {
		
		//System.out.println("===> Utilisateur : " + user.getNom());

		listeTrajetsEffectues = businessTrajet.getTrajetsEnCoursById(user.getIdUtilisateur());
		this.typeHistoTrajet = "Trajets en cours";
		this.afficheHistoTrajets = true;
		return "";
	}

	public String trajetsEffectues(Utilisateur user) {

		//this.setListeTrajetsEffectues(this.businessTrajet.getTrajetsEffectuesById(idUser));
		this.typeHistoTrajet = "Trajets effectués";
		this.afficheHistoTrajets = true;
		return "";
	}
		
	public String trajetsProposes(Utilisateur user) {
		//this.setListeTrajetsProposes(this.businessTrajet.getTrajetsProposesById(idUser));
		this.typeHistoTrajet = "Trajets Proposés";
		this.afficheHistoTrajets = true;
		return "";
	}
	
	public IBusinessTrajet getBusinessTrajet() {
		return businessTrajet;
	}

	public void setBusinessTrajet(IBusinessTrajet businessTrajet) {
		this.businessTrajet = businessTrajet;
	}

	public String getTypeHistoTrajet() {
		return typeHistoTrajet;
	}

	public void setTypeHistoTrajet(String typeHistoTrajet) {
		this.typeHistoTrajet = typeHistoTrajet;
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

}
