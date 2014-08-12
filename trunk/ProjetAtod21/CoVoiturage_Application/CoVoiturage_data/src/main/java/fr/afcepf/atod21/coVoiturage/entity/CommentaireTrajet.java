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

	//bi-directional many-to-one association to Trajet
	@ManyToOne
	private Trajet trajet;

    private String commetaire;
    
    private int commentaireIdQR;

    private String commentaireTypeQR;

	public CommentaireTrajet() {
	}

	public int getIdCommentaireTrajet() {
		return this.idCommentaireTrajet;
	}

	public void setIdCommentaireTrajet(int idCommentaireTrajet) {
		this.idCommentaireTrajet = idCommentaireTrajet;
	}

	public Trajet getTrajet() {
		return this.trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

    /**
     * @return the commetaire
     */
    public String getCommetaire() {
        return commetaire;
    }

    /**
     * @param paramCommetaire the commetaire to set
     */
    public void setCommetaire(String paramCommetaire) {
        commetaire = paramCommetaire;
    }

    /**
     * @return the commentaireIdQR
     */
    public int getCommentaireIdQR() {
        return commentaireIdQR;
    }

    /**
     * @param paramCommentaireIdQR the commentaireIdQR to set
     */
    public void setCommentaireIdQR(int paramCommentaireIdQR) {
        commentaireIdQR = paramCommentaireIdQR;
    }

    /**
     * @return the commentaireTypeQR
     */
    public String getCommentaireTypeQR() {
        return commentaireTypeQR;
    }

    /**
     * @param paramCommentaireTypeQR the commentaireTypeQR to set
     */
    public void setCommentaireTypeQR(String paramCommentaireTypeQR) {
        commentaireTypeQR = paramCommentaireTypeQR;
    }

    /**
     * @param paramTrajet
     * @param paramCommetaire
     * @param paramCommentaireIdQR
     * @param paramCommentaireTypeQR
     */
    public CommentaireTrajet(Trajet paramTrajet, String paramCommetaire,
            int paramCommentaireIdQR, String paramCommentaireTypeQR) {
        super();
        trajet = paramTrajet;
        commetaire = paramCommetaire;
        commentaireIdQR = paramCommentaireIdQR;
        commentaireTypeQR = paramCommentaireTypeQR;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CommentaireTrajet [idCommentaireTrajet=" + idCommentaireTrajet
                + ", trajet=" + trajet + ", commetaire=" + commetaire
                + ", commentaireIdQR=" + commentaireIdQR
                + ", commentaireTypeQR=" + commentaireTypeQR + "]";
    }

}