package fr.afcepf.atod21.coVoiturage.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_utilisateur")
	private int idUtilisateur;

	private String civilite;

	@Temporal(TemporalType.DATE)
	@Column(name="date_naissance")
	private Date dateNaissance;

	private String email;

	private String nom;

	private String password;

	@Column(name="permis_conduire")
	private byte permisConduire;

	private String prenom;

	private String telephone;

	@Column(name="type_vehicule")
	private String typeVehicule;

	//bi-directional many-to-one association to Avi
	@OneToMany(mappedBy="utilisateur")
	private List<Avis> avis;

	//bi-directional many-to-one association to CommentaireTrajet
	@OneToMany(mappedBy="utilisateur")
	private List<CommentaireTrajet> commentaireTrajets;

	//bi-directional many-to-one association to Adresse
	@ManyToOne
	private Adresse adresse;

	//bi-directional many-to-many association to Trajet
	@ManyToMany
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

	public byte getPermisConduire() {
		return this.permisConduire;
	}

	public void setPermisConduire(byte permisConduire) {
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

	public List<CommentaireTrajet> getCommentaireTrajets() {
		return this.commentaireTrajets;
	}

	public void setCommentaireTrajets(List<CommentaireTrajet> commentaireTrajets) {
		this.commentaireTrajets = commentaireTrajets;
	}

	public CommentaireTrajet addCommentaireTrajet(CommentaireTrajet commentaireTrajet) {
		getCommentaireTrajets().add(commentaireTrajet);
		commentaireTrajet.setUtilisateur(this);

		return commentaireTrajet;
	}

	public CommentaireTrajet removeCommentaireTrajet(CommentaireTrajet commentaireTrajet) {
		getCommentaireTrajets().remove(commentaireTrajet);
		commentaireTrajet.setUtilisateur(null);

		return commentaireTrajet;
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

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", civilite="
				+ civilite + ", dateNaissance=" + dateNaissance + ", email="
				+ email + ", nom=" + nom + ", password=" + password
				+ ", permisConduire=" + permisConduire + ", prenom=" + prenom
				+ ", telephone=" + telephone + ", typeVehicule=" + typeVehicule
				+ "]";
	}
}