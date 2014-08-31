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

    private String commentaire;
    
	@Column(name="commentaire_id_QR")
    private int commentaireIdQR;

	@Column(name="commentaire_type_QR")
    private String commentaireTypeQR;

	//bi-directional many-to-one association to Trajet
	@ManyToOne
	private Trajet trajet;

	public CommentaireTrajet() {
	}
	
	public CommentaireTrajet(int idCommentaireTrajet, Trajet trajet,
			String commentaire, int commentaireIdQR, String commentaireTypeQR) {
		super();
		this.idCommentaireTrajet = idCommentaireTrajet;
		this.trajet = trajet;
		this.commentaire = commentaire;
		this.commentaireIdQR = commentaireIdQR;
		this.commentaireTypeQR = commentaireTypeQR;
	}


	public int getIdCommentaireTrajet() {
		return this.idCommentaireTrajet;
	}

	public void setIdCommentaireTrajet(int idCommentaireTrajet) {
		this.idCommentaireTrajet = idCommentaireTrajet;
	}

    public int getCommentaireIdQR() {
        return commentaireIdQR;
    }

    public void setCommentaireIdQR(int paramCommentaireIdQR) {
        commentaireIdQR = paramCommentaireIdQR;
    }

    public String getCommentaireTypeQR() {
        return commentaireTypeQR;
    }

    public void setCommentaireTypeQR(String paramCommentaireTypeQR) {
        commentaireTypeQR = paramCommentaireTypeQR;
    }

    
    public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Trajet getTrajet() {
		return this.trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

	@Override
	public String toString() {
		return "CommentaireTrajet [idCommentaireTrajet=" + idCommentaireTrajet
				+ ", commentaire=" + commentaire + ", commentaireIdQR="
				+ commentaireIdQR + ", commentaireTypeQR=" + commentaireTypeQR
				+ "]";
	}


}