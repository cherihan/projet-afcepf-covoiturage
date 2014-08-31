package fr.afcepf.atod21.coVoiturage.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import java.util.List;
import java.util.Set;


/**
 * The persistent class for the ville database table.
 * 
 */
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ville-type", propOrder = {"nom", "codePostal", "pays"})
@NamedQuery(name="Ville.findAll", query="SELECT v FROM Ville v")
public class Ville implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ville")
	@XmlTransient
	private int idVille;

	@XmlElement(required = true)
    private String nom;

    @Column(name="code_postal")
    @XmlElement(required = true)
	private String codePostal;

    @XmlElement(required = true)
	private String pays;

	//bi-directional many-to-one association to Adresse
	@OneToMany(mappedBy="ville")
	@XmlTransient
	private Set<Adresse> adresses;

	//bi-directional many-to-one association to Trajet
	@OneToMany(mappedBy="villeDepart")
	@XmlTransient
	private Set<Trajet> trajets1;

	//bi-directional many-to-one association to Trajet
	@OneToMany(mappedBy="villeArrivee")
	@XmlTransient
	private Set<Trajet> trajets2;

	public Ville() {
	}

	
	public Ville(int idVille, String nom, String codePostal, String pays,
			Set<Adresse> adresses, Set<Trajet> trajets1, Set<Trajet> trajets2) {
		super();
		this.idVille = idVille;
		this.nom = nom;
		this.codePostal = codePostal;
		this.pays = pays;
		this.adresses = adresses;
		this.trajets1 = trajets1;
		this.trajets2 = trajets2;
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


	@Override
	public String toString() {
		return "Ville [idVille=" + idVille + ", nom=" + nom + ", codePostal="
				+ codePostal + ", pays=" + pays + "]";
	}

}