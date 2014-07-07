package fr.afcepf.atod21.coVoiturage.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ville database table.
 * 
 */
@Entity
@NamedQuery(name="Ville.findAll", query="SELECT v FROM Ville v")
public class Ville implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ville")
	private int idVille;

	@Column(name="code_postal")
	private String codePostal;

	private String nom;

	private String pays;

	//bi-directional many-to-one association to Adresse
	@OneToMany(mappedBy="ville")
	private List<Adresse> adresses;

	//bi-directional many-to-one association to Trajet
	@OneToMany(mappedBy="ville1")
	private List<Trajet> trajets1;

	//bi-directional many-to-one association to Trajet
	@OneToMany(mappedBy="ville2")
	private List<Trajet> trajets2;

	public Ville() {
	}

	public int getIdVille() {
		return this.idVille;
	}

	public void setIdVille(int idVille) {
		this.idVille = idVille;
	}

	public String getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public List<Adresse> getAdresses() {
		return this.adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	public Adresse addAdress(Adresse adress) {
		getAdresses().add(adress);
		adress.setVille(this);

		return adress;
	}

	public Adresse removeAdress(Adresse adress) {
		getAdresses().remove(adress);
		adress.setVille(null);

		return adress;
	}

	public List<Trajet> getTrajets1() {
		return this.trajets1;
	}

	public void setTrajets1(List<Trajet> trajets1) {
		this.trajets1 = trajets1;
	}

	public Trajet addTrajets1(Trajet trajets1) {
		getTrajets1().add(trajets1);
		trajets1.setVille1(this);

		return trajets1;
	}

	public Trajet removeTrajets1(Trajet trajets1) {
		getTrajets1().remove(trajets1);
		trajets1.setVille1(null);

		return trajets1;
	}

	public List<Trajet> getTrajets2() {
		return this.trajets2;
	}

	public void setTrajets2(List<Trajet> trajets2) {
		this.trajets2 = trajets2;
	}

	public Trajet addTrajets2(Trajet trajets2) {
		getTrajets2().add(trajets2);
		trajets2.setVille2(this);

		return trajets2;
	}

	public Trajet removeTrajets2(Trajet trajets2) {
		getTrajets2().remove(trajets2);
		trajets2.setVille2(null);

		return trajets2;
	}

}