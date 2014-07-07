package fr.afcepf.atod21.coVoiturage.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the commentaire_trajet database table.
 * 
 */
@Entity
@Table(name="commentaire_trajet")
@NamedQuery(name="CommentaireTrajet.findAll", query="SELECT c FROM CommentaireTrajet c")
public class CommentaireTrajet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_commentaire_trajet")
	private int idCommentaireTrajet;

	private String contenu;

	//bi-directional many-to-one association to Trajet
	@ManyToOne
	private Trajet trajet;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	private Utilisateur utilisateur;

	public CommentaireTrajet() {
	}

	public int getIdCommentaireTrajet() {
		return this.idCommentaireTrajet;
	}

	public void setIdCommentaireTrajet(int idCommentaireTrajet) {
		this.idCommentaireTrajet = idCommentaireTrajet;
	}

	public String getContenu() {
		return this.contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Trajet getTrajet() {
		return this.trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}