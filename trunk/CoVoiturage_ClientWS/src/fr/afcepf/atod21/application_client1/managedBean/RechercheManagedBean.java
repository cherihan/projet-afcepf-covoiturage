package fr.afcepf.atod21.application_client1.managedBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;

import fr.afcepf.atod21.application_client1.common.Common;
import fr.afcepf.atod21.covoiturage.servicesimpl.Exception;
import fr.afcepf.atod21.covoiturage.servicesimpl.FileNotFoundException;
import fr.afcepf.atod21.covoiturage.servicesimpl.IInscriptionTrajetServiceSoap;
import fr.afcepf.atod21.covoiturage.servicesimpl.IOException;
import fr.afcepf.atod21.covoiturage.servicesimpl.IOrchestrateurSoap;
import fr.afcepf.atod21.covoiturage.servicesimpl.InscriptionTrajetServiceSoapService;
import fr.afcepf.atod21.covoiturage.servicesimpl.OrchestrateurSoapService;





@ManagedBean(name="rechercheMB", eager=true)
@SessionScoped
public class RechercheManagedBean {
	
	private String villeDepart;
	private String villeArrivee;
	private String dateDepart;
	private boolean displayTableResultsTrajets = false;
	private HtmlDataTable dataTableTrajets = new HtmlDataTable();
	private List<Trajet> listeDeTrajet;
	private boolean isInscrit=false;
	
	public boolean isInscrit() {
		return isInscrit;
	}
	public void setInscrit(boolean isInscrit) {
		this.isInscrit = isInscrit;
	}
	public boolean CoVoiturage_Orchestrateur() {
		
		System.out.println("========= debut ==============");
		// appel WS avec isIncrit=retour
//		InscriptionTrajetServiceSoapService service= new InscriptionTrajetServiceSoapService();
//		IInscriptionTrajetServiceSoap inscrire=service.getInscriptionTrajetServiceSoapPort();
//		
		OrchestrateurSoapService orchestrteurService= new OrchestrateurSoapService();
		IOrchestrateurSoap ws = orchestrteurService.getOrchestrateurSoapPort();
		
		try {
			if (ws.entryMethod(3, 27, 1)) System.out.println("===== Inscription réussite======> ");
		} catch (Exception e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		return isInscrit;
	}
	public String rechercherTrajet() {
		String retour = "listerTrajets";
		Date dateDeDepart = Common.convertDate(this.dateDepart);
		List<Trajet> listeDeTrajet = new ArrayList<Trajet>();
		
		Trajet trajet = new Trajet();
		trajet.setNbre_de_place(4);
		trajet.setPrix(30);
		trajet.setVilleDepart("paris");
		trajet.setVilleArrivee("Lyon");
		trajet.setDateDepart("01/01/2015 10:00");
		listeDeTrajet.add(trajet);
		
		Trajet trajet2 = new Trajet();
		trajet2.setNbre_de_place(3);
		trajet2.setPrix(25);
		trajet2.setVilleDepart("paris");
		trajet2.setVilleArrivee("Lyon");
		trajet2.setDateDepart("01/01/2015 10:00");
		listeDeTrajet.add(trajet2);
		
		Trajet trajet3 = new Trajet();
		trajet3.setNbre_de_place(2);
		trajet3.setPrix(20);
		trajet3.setVilleDepart("paris");
		trajet3.setVilleArrivee("Lyon");
		trajet3.setDateDepart("01/01/2015 10:00");
		listeDeTrajet.add(trajet3);
		
		
		if (listeDeTrajet != null) {
			this.displayTableResultsTrajets = true;
			System.out.println("liste de trajets : " + listeDeTrajet);
				
		}

		if (listeDeTrajet.size() == 0 || listeDeTrajet == null) {
			FacesMessage message = new FacesMessage("Aucun resultat disponible !");
			FacesContext.getCurrentInstance().addMessage(null, message);
			this.displayTableResultsTrajets = false;
			retour = "error";
		}
		this.listeDeTrajet=listeDeTrajet;
		return retour;
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

	public HtmlDataTable getDataTableTrajets() {
		return dataTableTrajets;
	}

	public void setDataTableTrajets(HtmlDataTable dataTableTrajets) {
		this.dataTableTrajets = dataTableTrajets;
	}

	public List<Trajet> getListeDeTrajet() {
		return listeDeTrajet;
	}

	public void setListeDeTrajet(List<Trajet> listeDeTrajet) {
		this.listeDeTrajet = listeDeTrajet;
	}

}
