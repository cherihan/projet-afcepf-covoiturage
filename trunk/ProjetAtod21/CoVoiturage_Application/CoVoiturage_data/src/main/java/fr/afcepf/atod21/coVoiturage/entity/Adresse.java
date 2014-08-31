package fr.afcepf.atod21.coVoiturage.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import java.util.List;


/**
 * The persistent class for the adresse database table.
 * 
 */
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "address-type", propOrder = {"numero", "typeVoie", "nomVoie", "ville"})
@NamedQuery(name="Adresse.findAll", query="SELECT a FROM Adresse a")
public class Adresse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_adresse")
	@XmlTransient
	private int idAdresse;

	@XmlElement(required = true)
    private String numero;

    @Column(name="type_voie")
    @XmlElement(required = true)
    private String typeVoie;

    @Column(name="nom_voie")
    @XmlElement(required = true)
	private String nomVoie;

	//bi-directional many-to-one association to Ville
	@ManyToOne
	@XmlElement(name = "ville-adresse", required = true)
	private Ville ville;

	//bi-directional many-to-one association to Utilisateur
	@OneToMany(mappedBy="adresse")
	@XmlTransient
	private List<Utilisateur> utilisateurs;

	public Adresse() {
	}



	public Adresse(int idAdresse, String numero, String typeVoie,
			String nomVoie, Ville ville, List<Utilisateur> utilisateurs) {
		super();
		this.idAdresse = idAdresse;
		this.numero = numero;
		this.typeVoie = typeVoie;
		this.nomVoie = nomVoie;
		this.ville = ville;
		this.utilisateurs = utilisateurs;
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



	@Override
	public String toString() {
		return "Adresse [idAdresse=" + idAdresse + ", numero=" + numero
				+ ", typeVoie=" + typeVoie + ", nomVoie=" + nomVoie
				+ ", ville=" + ville + "]";
	}



}