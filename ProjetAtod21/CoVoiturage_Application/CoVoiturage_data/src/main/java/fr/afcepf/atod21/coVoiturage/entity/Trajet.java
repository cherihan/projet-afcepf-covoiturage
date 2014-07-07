package fr.afcepf.atod21.coVoiturage.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the trajet database table.
 * 
 */
@Entity
@NamedQuery(name="Trajet.findAll", query="SELECT t FROM Trajet t")
public class Trajet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_trajet")
	private int idTrajet;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_depart")
	private Date dateDepart;

	@Column(name="nb_passagers")
	private int nbPassagers;

	private String statut;

	private int tarif;

	//bi-directional many-to-one association to Avi
	@OneToMany(mappedBy="trajet")
	private List<Avis> avis;

	//bi-directional many-to-one association to CommentaireTrajet
	@OneToMany(mappedBy="trajet")
	private List<CommentaireTrajet> commentaireTrajets;

	//bi-directional many-to-one association to Ville
	@ManyToOne
	@JoinColumn(name="ville_depart_id")
	private Ville ville1;

	//bi-directional many-to-one association to Ville
	@ManyToOne
	@JoinColumn(name="ville_arrivee_id")
	private Ville ville2;

	//bi-directional many-to-many association to Utilisateur
	@ManyToMany(mappedBy="trajets")
	private List<Utilisateur> utilisateurs;

	public Trajet() {
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

	public int getNbPassagers() {
		return this.nbPassagers;
	}

	public void setNbPassagers(int nbPassagers) {
		this.nbPassagers = nbPassagers;
	}

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public int getTarif() {
		return this.tarif;
	}

	public void setTarif(int tarif) {
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

	public CommentaireTrajet addCommentaireTrajet(CommentaireTrajet commentaireTrajet) {
		getCommentaireTrajets().add(commentaireTrajet);
		commentaireTrajet.setTrajet(this);

		return commentaireTrajet;
	}

	public CommentaireTrajet removeCommentaireTrajet(CommentaireTrajet commentaireTrajet) {
		getCommentaireTrajets().remove(commentaireTrajet);
		commentaireTrajet.setTrajet(null);

		return commentaireTrajet;
	}

	public Ville getVille1() {
		return this.ville1;
	}

	public void setVille1(Ville ville1) {
		this.ville1 = ville1;
	}

	public Ville getVille2() {
		return this.ville2;
	}

	public void setVille2(Ville ville2) {
		this.ville2 = ville2;
	}

	public List<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

}