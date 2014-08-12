package fr.afcepf.atod21.coVoiturage.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the adresse database table.
 * 
 */
@Entity
@NamedQuery(name="Adresse.findAll", query="SELECT a FROM Adresse a")
public class Adresse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_adresse")
	private int idAdresse;

    private String numero;

    @Column(name="type_voie")
    private String typeVoie;

    @Column(name="nom_voie")
	private String nomVoie;

	//bi-directional many-to-one association to Ville
	@ManyToOne
	private Ville ville;

	//bi-directional many-to-one association to Utilisateur
	@OneToMany(mappedBy="adresse")
	private List<Utilisateur> utilisateurs;

	public Adresse() {
	}

	public int getIdAdresse() {
		return this.idAdresse;
	}

	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}

	public String getNomVoie() {
		return this.nomVoie;
	}

	public void setNomVoie(String nomVoie) {
		this.nomVoie = nomVoie;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTypeVoie() {
		return this.typeVoie;
	}

	public void setTypeVoie(String typeVoie) {
		this.typeVoie = typeVoie;
	}

	public Ville getVille() {
		return this.ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public List<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().add(utilisateur);
		utilisateur.setAdresse(this);

		return utilisateur;
	}

	public Utilisateur removeUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().remove(utilisateur);
		utilisateur.setAdresse(null);

		return utilisateur;
	}

    /**
     * @param paramNumero
     * @param paramTypeVoie
     * @param paramNomVoie
     * @param paramVille
     * @param paramUtilisateurs
     */
    public Adresse(String paramNumero, String paramTypeVoie,
            String paramNomVoie, Ville paramVille,
            List<Utilisateur> paramUtilisateurs) {
        super();
        numero = paramNumero;
        typeVoie = paramTypeVoie;
        nomVoie = paramNomVoie;
        ville = paramVille;
        utilisateurs = paramUtilisateurs;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Adresse [idAdresse=" + idAdresse + ", numero=" + numero
                + ", typeVoie=" + typeVoie + ", nomVoie=" + nomVoie
                + ", ville=" + ville + ", utilisateurs=" + utilisateurs + "]";
    }


}