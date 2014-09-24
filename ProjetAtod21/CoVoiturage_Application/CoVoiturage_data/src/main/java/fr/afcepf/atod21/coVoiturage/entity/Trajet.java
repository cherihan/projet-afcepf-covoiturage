package fr.afcepf.atod21.coVoiturage.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * The persistent class for the trajet database table.
 * 
 */
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"dateCreation", "conducteurIdUser", "dateDepart", "villeDepart", "villeArrivee",
								"nbPassagersMax", "nbPassagersRestant", "tarif", "statut"})
@XmlRootElement(name = "trajet")
@NamedQuery(name = "Trajet.findAll", query = "SELECT t FROM Trajet t")
public class Trajet implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trajet")
    @XmlTransient
    private int idTrajet;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_creation")
    @XmlElement(required = true)
    private Date dateCreation;

    @Column(name = "conducteur_id_user")
    @XmlElement(required = true)
    private int conducteurIdUser;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_depart")
    @XmlElement(required = true)
    private Date dateDepart;

    // bi-directional many-to-one association to Ville
    @ManyToOne
    @JoinColumn(name = "ville_depart_id")
    @XmlElement(name = "trajet-villeDepart", required = true)
    private Ville villeDepart;

    // bi-directional many-to-one association to Ville
    @ManyToOne
    @JoinColumn(name = "ville_arrivee_id")
    @XmlElement(name = "trajet-villeArrivee", required = true)
    private Ville villeArrivee;

    @Column(name = "nb_passagers_max")
    @XmlElement(required = true)
    private int nbPassagersMax;

    @Column(name = "nb_passagers_restant")
    @XmlElement(required = true)
    private int nbPassagersRestant;

    @XmlElement(required = true)
    private int tarif;
    
    @XmlElement(required = true)
    private String statut;

    // bi-directional many-to-one association to Avis
    @OneToMany(mappedBy = "trajet")
    @XmlTransient
    private List<Avis> avis;

    // bi-directional many-to-one association to CommentaireTrajet
    @OneToMany(mappedBy = "trajet")
    @XmlTransient
    private List<CommentaireTrajet> commentaireTrajets;

    // bi-directional many-to-many association to Utilisateur
    @ManyToMany(mappedBy = "trajets")
    @XmlTransient
    private List<Utilisateur> utilisateurs;

    public Trajet() {
    }
    
    public Trajet(Date dateCreation, int conducteurIdUser, Date dateDepart,
			Ville villeDepart, Ville villeArrivee, int nbPassagersMax,
			int nbPassagersRestant, int tarif) {
		super();
		this.dateCreation = dateCreation;
		this.conducteurIdUser = conducteurIdUser;
		this.dateDepart = dateDepart;
		this.villeDepart = villeDepart;
		this.villeArrivee = villeArrivee;
		this.nbPassagersMax = nbPassagersMax;
		this.nbPassagersRestant = nbPassagersRestant;
		this.tarif = tarif;
	}
    
    public Trajet(Date dateCreation, int conducteurIdUser, Date dateDepart,
            Ville villeDepart, Ville villeArrivee, int nbPassagersMax,
            int nbPassagersRestant, int tarif, String statut) {
        super();
        this.dateCreation = dateCreation;
        this.conducteurIdUser = conducteurIdUser;
        this.dateDepart = dateDepart;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.nbPassagersMax = nbPassagersMax;
        this.nbPassagersRestant = nbPassagersRestant;
        this.tarif = tarif;
        this.statut = statut;
    }


	public Trajet(int idTrajet, Date dateCreation, int conducteurIdUser,
			Date dateDepart, Ville villeDepart, Ville villeArrivee,
			int nbPassagersMax, int nbPassagersRestant, int tarif,
			String statut, List<Avis> avis,
			List<CommentaireTrajet> commentaireTrajets,
			List<Utilisateur> utilisateurs) {
		super();
		this.idTrajet = idTrajet;
		this.dateCreation = dateCreation;
		this.conducteurIdUser = conducteurIdUser;
		this.dateDepart = dateDepart;
		this.villeDepart = villeDepart;
		this.villeArrivee = villeArrivee;
		this.nbPassagersMax = nbPassagersMax;
		this.nbPassagersRestant = nbPassagersRestant;
		this.tarif = tarif;
		this.statut = statut;
		this.avis = avis;
		this.commentaireTrajets = commentaireTrajets;
		this.utilisateurs = utilisateurs;
	}


	/**
     * @return the dateCreation
     */
    public Date getDateCreation() {
        return this.dateCreation;
    }

    /**
     * @param paramDateCreation
     *            the dateCreation to set
     */
    public void setDateCreation(Date paramDateCreation) {
        this.dateCreation = paramDateCreation;
    }

    /**
     * @return the conducteurIdUser
     */
    public int getConducteurIdUser() {
        return conducteurIdUser;
    }

    /**
     * @param paramConducteurIdUser
     *            the conducteurIdUser to set
     */
    public void setConducteurIdUser(int paramConducteurIdUser) {
        conducteurIdUser = paramConducteurIdUser;
    }

    /**
     * @return the nbPassagersMax
     */
    public int getNbPassagersMax() {
        return nbPassagersMax;
    }

    /**
     * @param paramNbPassagersMax
     *            the nbPassagersMax to set
     */
    public void setNbPassagersMax(int paramNbPassagersMax) {
        nbPassagersMax = paramNbPassagersMax;
    }

    /**
     * @return the nbPassagersRestant
     */
    public int getNbPassagersRestant() {
        return nbPassagersRestant;
    }

    /**
     * @param paramNbPassagersRestant
     *            the nbPassagersRestant to set
     */
    public void setNbPassagersRestant(int paramNbPassagersRestant) {
        nbPassagersRestant = paramNbPassagersRestant;
    }

    public int getIdTrajet() {
        return this.idTrajet;
    }

    public void setIdTrajet(int idTrajet) {
        this.idTrajet = idTrajet;
    }

    public Date getDateDepart() {
        return this.dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public String getStatut() {
        return this.statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
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


    public List<Avis> getAvis() {
		return avis;
	}

	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}

	public List<CommentaireTrajet> getCommentaireTrajets() {
		return commentaireTrajets;
	}

	public void setCommentaireTrajets(List<CommentaireTrajet> commentaireTrajets) {
		this.commentaireTrajets = commentaireTrajets;
	}

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	@Override
	public String toString() {
		return "Trajet [idTrajet=" + idTrajet + ", dateCreation="
				+ dateCreation + ", conducteurIdUser=" + conducteurIdUser
				+ ", dateDepart=" + dateDepart + ", villeDepart=" + villeDepart
				+ ", villeArrivee=" + villeArrivee + ", nbPassagersMax="
				+ nbPassagersMax + ", nbPassagersRestant=" + nbPassagersRestant
				+ ", tarif=" + tarif + ", statut=" + statut + "]";
	}




}