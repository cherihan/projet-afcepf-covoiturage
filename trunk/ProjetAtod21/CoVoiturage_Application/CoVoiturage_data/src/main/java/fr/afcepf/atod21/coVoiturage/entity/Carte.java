package fr.afcepf.atod21.coVoiturage.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the carte database table.
 * 
 */
@Entity
@NamedQuery(name="Carte.findAll", query="SELECT c FROM Carte c")
public class Carte implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_carte")
    private int idCarte;

    private String porteur;
 
    @Column(name="num_carte")
    private String numCarte;
    
    private String cryptogramme;

    @Temporal(TemporalType.DATE)
    @Column(name="date_expiration")
    private Date dateExpiration;
    

    //bi-directional many-to-one association to Utilisateur
    @ManyToOne
    private Utilisateur utilisateur;
    
    public Carte() {
        
    }

    /**
     * @return the idCarte
     */
    public int getIdCarte() {
        return idCarte;
    }

    /**
     * @param paramIdCarte the idCarte to set
     */
    public void setIdCarte(int paramIdCarte) {
        idCarte = paramIdCarte;
    }

    /**
     * @return the porteur
     */
    public String getPorteur() {
        return porteur;
    }

    /**
     * @param paramPorteur the porteur to set
     */
    public void setPorteur(String paramPorteur) {
        porteur = paramPorteur;
    }


    /**
     * @return the dateExpiration
     */
    public Date getDateExpiration() {
        return dateExpiration;
    }

    /**
     * @param paramDateExpiration the dateExpiration to set
     */
    public void setDateExpiration(Date paramDateExpiration) {
        dateExpiration = paramDateExpiration;
    }

    /**
     * @return the numCarte
     */
    public String getNumCarte() {
        return numCarte;
    }

    /**
     * @param paramNumCarte the numCarte to set
     */
    public void setNumCarte(String paramNumCarte) {
        numCarte = paramNumCarte;
    }

    /**
     * @return the cryptogramme
     */
    public String getCryptogramme() {
        return cryptogramme;
    }

    /**
     * @param paramCryptogramme the cryptogramme to set
     */
    public void setCryptogramme(String paramCryptogramme) {
        cryptogramme = paramCryptogramme;
    }

    /**
     * @return the utilisateur
     */
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    /**
     * @param paramUtilisateur the utilisateur to set
     */
    public void setUtilisateur(Utilisateur paramUtilisateur) {
        utilisateur = paramUtilisateur;
    }

    /**
     * @param paramPorteur
     * @param paramNumCarte
     * @param paramCryptogramme
     * @param paramDateExpiration
     * @param paramUtilisateur
     */
    public Carte(String paramPorteur, String paramNumCarte,
            String paramCryptogramme, Date paramDateExpiration,
            Utilisateur paramUtilisateur) {
        super();
        porteur = paramPorteur;
        numCarte = paramNumCarte;
        cryptogramme = paramCryptogramme;
        dateExpiration = paramDateExpiration;
        utilisateur = paramUtilisateur;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Carte [idCarte=" + idCarte + ", porteur=" + porteur
                + ", numCarte=" + numCarte + ", dateExpiration="
                + dateExpiration + ", cryptogramme=" + cryptogramme + "]";
    }
    
    
}
