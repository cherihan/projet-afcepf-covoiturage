package fr.afcepf.atod21.coVoiturage.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the avis database table.
 * 
 */
@Entity
@Table(name="avis")
@NamedQuery(name="Avis.findAll", query="SELECT a FROM Avis a")
public class Avis implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_avis")
	private int idAvis;

	private String contenu;

	private String note;

    //bi-directional many-to-one association to Utilisateur
    @ManyToOne
    private Utilisateur utilisateur;

    //bi-directional many-to-one association to Trajet
	@ManyToOne
	private Trajet trajet;

	public Avis() {
	}

	public int getIdAvis() {
		return this.idAvis;
	}

	public void setIdAvis(int idAvis) {
		this.idAvis = idAvis;
	}

	public String getContenu() {
		return this.contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
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

    /**
     * @param paramContenu
     * @param paramNote
     * @param paramUtilisateur
     * @param paramTrajet
     */
    public Avis(String paramContenu, String paramNote,
            Utilisateur paramUtilisateur, Trajet paramTrajet) {
        super();
        contenu = paramContenu;
        note = paramNote;
        utilisateur = paramUtilisateur;
        trajet = paramTrajet;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Avis [idAvis=" + idAvis + ", contenu=" + contenu + ", note="
                + note + ", utilisateur=" + utilisateur + ", trajet=" + trajet
                + "]";
    }

}