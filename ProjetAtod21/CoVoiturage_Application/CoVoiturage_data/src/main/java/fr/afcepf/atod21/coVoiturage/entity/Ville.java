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

    private String nom;

    @Column(name="code_postal")
	private String codePostal;

	private String pays;

	//bi-directional many-to-one association to Adresse
	@OneToMany(mappedBy="ville", fetch=FetchType.EAGER)
	private List<Adresse> adresses;

	//bi-directional many-to-one association to Trajet
	@OneToMany(mappedBy="villeDepart")
	private List<Trajet> trajets1;

	//bi-directional many-to-one association to Trajet
	@OneToMany(mappedBy="villeArrivee")
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
		trajets1.setVilleDepart(this);

		return trajets1;
	}

	public Trajet removeTrajets1(Trajet trajets1) {
		getTrajets1().remove(trajets1);
		trajets1.setVilleDepart(null);

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
		trajets2.setVilleArrivee(this);

		return trajets2;
	}

	public Trajet removeTrajets2(Trajet trajets2) {
		getTrajets2().remove(trajets2);
		trajets2.setVilleArrivee(null);

		return trajets2;
	}

    /**
     * @param paramNom
     * @param paramCodePostal
     * @param paramPays
     * @param paramAdresses
     * @param paramTrajets1
     * @param paramTrajets2
     */
    public Ville(String paramNom, String paramCodePostal, String paramPays,
            List<Adresse> paramAdresses, List<Trajet> paramTrajets1,
            List<Trajet> paramTrajets2) {
        super();
        nom = paramNom;
        codePostal = paramCodePostal;
        pays = paramPays;
        adresses = paramAdresses;
        trajets1 = paramTrajets1;
        trajets2 = paramTrajets2;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Ville [idVille=" + idVille + ", nom=" + nom + ", codePostal="
                + codePostal + ", pays=" + pays + ", adresses=" + adresses
                + ", trajets1=" + trajets1 + ", trajets2=" + trajets2 + "]";
    }


}