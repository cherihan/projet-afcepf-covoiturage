package fr.afcepf.atod21.coVoiturage.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@XmlRootElement
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_utilisateur")
	private int idUtilisateur;

	private String civilite;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String telephone;

	@Temporal(TemporalType.DATE)
	@Column(name="date_naissance")
	private Date dateNaissance;

    @Column(name="type_vehicule")
    private String typeVehicule;

    @Column(name="permis_conduire")
	private String permisConduire;

    //bi-directional many-to-one association to Adresse
    @ManyToOne
    private Adresse adresse;

    //bi-directional many-to-one association to Avis
	@OneToMany(mappedBy="utilisateur")
	private List<Avis> avis;

	//bi-directional many-to-many association to Trajet
	@ManyToMany()
	@JoinTable(
		name="utilisateur_has_trajet"
		, joinColumns={
			@JoinColumn(name="utilisateur_id_utilisateur")
			}
		, inverseJoinColumns={
			@JoinColumn(name="trajet_id_trajet")
			}
		)
	private List<Trajet> trajets;

    //bi-directional one-to-many association to Carte
    @OneToMany(mappedBy="utilisateur")
    private List<Carte> cartes;

	public Utilisateur() {
	}

	public int getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getCivilite() {
		return this.civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPermisConduire() {
		return this.permisConduire;
	}

	public void setPermisConduire(String permisConduire) {
		this.permisConduire = permisConduire;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTypeVehicule() {
		return this.typeVehicule;
	}

	public void setTypeVehicule(String typeVehicule) {
		this.typeVehicule = typeVehicule;
	}

	public List<Avis> getAvis() {
		return this.avis;
	}

	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}

	public Avis addAvi(Avis avi) {
		getAvis().add(avi);
		avi.setUtilisateur(this);

		return avi;
	}

	public Avis removeAvi(Avis avi) {
		getAvis().remove(avi);
		avi.setUtilisateur(null);

		return avi;
	}

	public Adresse getAdresse() {
		return this.adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Trajet> getTrajets() {
		return this.trajets;
	}

	public void setTrajets(List<Trajet> trajets) {
		this.trajets = trajets;
	}

	/**
     * @return the cartes
     */
    public List<Carte> getCartes() {
        return cartes;
    }

    /**
     * @param paramCartes the cartes to set
     */
    public void setCartes(List<Carte> paramCartes) {
        cartes = paramCartes;
    }

    /**
     * @param paramCivilite
     * @param paramNom
     * @param paramPrenom
     * @param paramEmail
     * @param paramPassword
     * @param paramTelephone
     * @param paramDateNaissance
     * @param paramTypeVehicule
     * @param paramPermisConduire
     * @param paramAdresse
     * @param paramAvis
     * @param paramTrajets
     * @param paramCartes
     */
    public Utilisateur(String paramCivilite, String paramNom,
            String paramPrenom, String paramEmail, String paramPassword,
            String paramTelephone, Date paramDateNaissance,
            String paramTypeVehicule, String paramPermisConduire,
            Adresse paramAdresse, List<Avis> paramAvis,
            List<Trajet> paramTrajets, List<Carte> paramCartes) {
        super();
        civilite = paramCivilite;
        nom = paramNom;
        prenom = paramPrenom;
        email = paramEmail;
        password = paramPassword;
        telephone = paramTelephone;
        dateNaissance = paramDateNaissance;
        typeVehicule = paramTypeVehicule;
        permisConduire = paramPermisConduire;
        adresse = paramAdresse;
        avis = paramAvis;
        trajets = paramTrajets;
        cartes = paramCartes;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Utilisateur [idUtilisateur=" + idUtilisateur + ", civilite="
                + civilite + ", nom=" + nom + ", prenom=" + prenom + ", email="
                + email + ", password=" + password + ", telephone=" + telephone
                + ", dateNaissance=" + dateNaissance + ", typeVehicule="
                + typeVehicule + ", permisConduire=" + permisConduire
                + ", adresse=" + adresse + ", avis=" + avis + ", trajets="
                + trajets + ", cartes=" + cartes + "]";
    }

}