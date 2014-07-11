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

	private List<Trajet> listeHistoTrajets;
	private List<Trajet> listeTrajetsEffectues;
	private List<Trajet> listeTrajetsEnCours;
	private List<Trajet> listeTrajetsProposes;
	private String typeHistoTrajet;
	private boolean afficheHistoTrajets = false;

	@ManagedProperty(value = "#{businessTrajetImpl}")
	private IBusinessTrajet businessTrajet;

	public String histoTrajets(Utilisateur user, String typeHistoTrajets) {

		setListeHistoTrajets(businessTrajet.getHistoTrajets(
				user.getIdUtilisateur(), typeHistoTrajets));
		this.typeHistoTrajet = typeHistoTrajets;
		this.afficheHistoTrajets = true;

		switch (typeHistoTrajets) {
		case "en cours":
			setTypeHistoTrajet("Mes trajets en cours");
			break;
		case "effectues":
			setTypeHistoTrajet("Mes trajets effectués");
			break;

		case "proposes":
			setTypeHistoTrajet("Mes trajets proposés");
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

	public List<Trajet> getListeHistoTrajets() {
		return listeHistoTrajets;
	}

	public void setListeHistoTrajets(List<Trajet> listeHistoTrajets) {
		this.listeHistoTrajets = listeHistoTrajets;
	}

}
