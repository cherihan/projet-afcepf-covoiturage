package fr.afcepf.atod21.coVoiturage.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"civilite","shippingAddress", "nom", "prenom", "email", "password", "telephone",
								"dateNaissance", "typeVehicule", "permisConduire", "adresse"})
@XmlRootElement(name = "utilisateur")
@NamedQueries({
	@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u"),
	@NamedQuery(name="Utilisateur.findById",
    query="SELECT u FROM Utilisateur u WHERE u.idUtilisateur = :id"),
    @NamedQuery(name="Utilisateur.findByName",
    query="SELECT u FROM Utilisateur u WHERE u.nom = :nom")
})

public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_utilisateur")
	@XmlTransient
	private int idUtilisateur;

	@XmlElement(required = true)
	private String civilite;
	
	@XmlElement(required = true)
    private String nom;
	
	@XmlElement(required = true)
    private String prenom;
	
	@XmlElement(required = true)
    private String email;
	
	@XmlElement(required = true)
    private String password;
	
	@XmlElement(required = true)
    private String telephone;

	@Temporal(TemporalType.DATE)
	@Column(name="date_naissance")
	@XmlElement(required = true)
	private Date dateNaissance;

    @Column(name="type_vehicule")
    @XmlElement(required = true)
    private String typeVehicule;

    @Column(name="permis_conduire")
    @XmlElement(required = true)
	private String permisConduire;

    //bi-directional many-to-one association to Adresse
    @ManyToOne
    @XmlElement(name = "adresse-utilisateur", required = true)
    private Adresse adresse;

    //bi-directional many-to-one association to Avis
	@OneToMany(mappedBy="utilisateur")
	@XmlTransient
	private List<Avis> avis;

	//bi-directional many-to-many association to Trajet
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name="utilisateur_has_trajet"
		, joinColumns={
			@JoinColumn(name="utilisateur_id_utilisateur")
			}
		, inverseJoinColumns={
			@JoinColumn(name="trajet_id_trajet")
			}
		)
	@XmlTransient
	private List<Trajet> trajets;

    //bi-directional one-to-many association to Carte
    @OneToMany(mappedBy="utilisateur")
    @XmlTransient
    private List<Carte> cartes;

	public Utilisateur() {
	}

	public Utilisateur(int idUtilisateur, String civilite, String nom,
			String prenom, String email, String password, String telephone,
			Date dateNaissance, String typeVehicule, String permisConduire,
			Adresse adresse, List<Avis> avis, List<Trajet> trajets,
			List<Carte> cartes) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
		this.dateNaissance = dateNaissance;
		this.typeVehicule = typeVehicule;
		this.permisConduire = permisConduire;
		this.adresse = adresse;
		this.avis = avis;
		this.trajets = trajets;
		this.cartes = cartes;
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



	public Adresse getAdresse() {
		return this.adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Avis> getAvis() {
		return avis;
	}

	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}

	public List<Trajet> getTrajets() {
		return trajets;
	}

	public void setTrajets(List<Trajet> trajets) {
		this.trajets = trajets;
	}

	public List<Carte> getCartes() {
		return cartes;
	}

	public void setCartes(List<Carte> cartes) {
		this.cartes = cartes;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", civilite="
				+ civilite + ", nom=" + nom + ", prenom=" + prenom + ", email="
				+ email + ", password=" + password + ", telephone=" + telephone
				+ ", dateNaissance=" + dateNaissance + ", typeVehicule="
				+ typeVehicule + ", permisConduire=" + permisConduire
				+ ", adresse=" + adresse + "]";
	}


}