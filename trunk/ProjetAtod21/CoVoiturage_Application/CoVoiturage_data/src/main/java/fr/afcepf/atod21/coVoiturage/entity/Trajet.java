package fr.afcepf.atod21.coVoiturage.entity;

import java.io.Serializable;

import javax.persistence.*;

import fr.afcepf.atod21.coVoiturage.utils.Consts;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the trajet database table.
 * 
 */
@Entity
@NamedQuery(name = "Trajet.findAll", query = "SELECT t FROM Trajet t")
public class Trajet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_trajet")
	private int idTrajet;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_creation")
    private Date dateCreation;
    
    @Column(name = "conducteur_id_user")
    private int conducteurIdUser;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_depart")
    private Date dateDepart;
    
    // bi-directional many-to-one association to Ville
    @ManyToOne
    @JoinColumn(name = "ville_depart_id")
    private Ville villeDepart;

    // bi-directional many-to-one association to Ville
    @ManyToOne
    @JoinColumn(name = "ville_arrivee_id")
    private Ville villeArrivee;

    @Column(name = "nb_passagers_max")
    private int nbPassagersMax;
    
    @Column(name = "nb_passagers_restant")
    private int nbPassagersRestant;
    
    private Integer tarif;
	private String statut;
    
	// bi-directional many-to-one association to Avi
	@OneToMany(mappedBy = "trajet")
	private List<Avis> avis;

	// bi-directional many-to-one association to CommentaireTrajet
	@OneToMany(mappedBy = "trajet")
	private List<CommentaireTrajet> commentaireTrajets;

	// bi-directional many-to-many association to Utilisateur
	@ManyToMany(mappedBy = "trajets")
	private List<Utilisateur> utilisateurs;

	/**
     * @return the dateCreation
     */
    public Date getDateCreation() {
        return this.dateCreation;
    }

    /**
     * @param paramDateCreation the dateCreation to set
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
     * @param paramConducteurIdUser the conducteurIdUser to set
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
     * @param paramNbPassagersMax the nbPassagersMax to set
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
     * @param paramNbPassagersRestant the nbPassagersRestant to set
     */
    public void setNbPassagersRestant(int paramNbPassagersRestant) {
        nbPassagersRestant = paramNbPassagersRestant;
    }

    public Trajet() {
	}

	/**
     * @param paramDateCreation
     * @param paramConducteurIdUser
     * @param paramDateDepart
     * @param paramVilleDepart
     * @param paramVilleArrivee
     * @param paramNbPassagersMax
     * @param paramNbPassagersRestant
     * @param paramTarif
     */
    public Trajet(Date paramDateCreation, int paramConducteurIdUser, Date paramDateDepart, Ville paramVilleDepart,
            Ville paramVilleArrivee, int paramNbPassagersMax, int paramNbPassagersRestant, Integer paramTarif) {
        super();
        dateCreation = paramDateCreation;
        conducteurIdUser = paramConducteurIdUser;
        dateDepart = paramDateDepart;
        villeDepart = paramVilleDepart;
        villeArrivee = paramVilleArrivee;
        nbPassagersMax = paramNbPassagersMax;
        nbPassagersRestant = paramNbPassagersRestant;
        tarif = paramTarif;
        statut = Consts.PROPOSE;
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

    public Integer getTarif() {
        return tarif;
    }

    public void setTarif(Integer tarif) {
        this.tarif = tarif;
    }
    
	public List<Avis> getAvis() {
		return this.avis;
	}

	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}

	public Avis addAvi(Avis avi) {
		getAvis().add(avi);
		avi.setTrajet(this);

		return avi;
	}

	public Avis removeAvi(Avis avi) {
		getAvis().remove(avi);
		avi.setTrajet(null);

		return avi;
	}

	public List<CommentaireTrajet> getCommentaireTrajets() {
		return this.commentaireTrajets;
	}

	public void setCommentaireTrajets(List<CommentaireTrajet> commentaireTrajets) {
		this.commentaireTrajets = commentaireTrajets;
	}

	public CommentaireTrajet addCommentaireTrajet(
			CommentaireTrajet commentaireTrajet) {
		getCommentaireTrajets().add(commentaireTrajet);
		commentaireTrajet.setTrajet(this);

		return commentaireTrajet;
	}

	public CommentaireTrajet removeCommentaireTrajet(
			CommentaireTrajet commentaireTrajet) {
		getCommentaireTrajets().remove(commentaireTrajet);
		commentaireTrajet.setTrajet(null);

		return commentaireTrajet;
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

	
    public List<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	

	/* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
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