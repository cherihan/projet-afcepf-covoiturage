package fr.afcepf.atod21.coVoiturage.business.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class TrajetDto {

   
    private int idTrajet;
    private Date dateCreation;
    private int conducteurIdUser;
    private Date dateDepart;
    private String villeDepart;
    private String villeArrivee;
    private int nbPassagersMax;
    private int nbPassagersRestant;
    private Integer tarif;
    private String statut;
    /**
     * @return the idTrajet
     */
    public int getIdTrajet() {
        return idTrajet;
    }
    /**
     * @param paramIdTrajet the idTrajet to set
     */
    public void setIdTrajet(int paramIdTrajet) {
        idTrajet = paramIdTrajet;
    }
    /**
     * @return the dateCreation
     */
    public Date getDateCreation() {
        return dateCreation;
    }
    /**
     * @param paramDateCreation the dateCreation to set
     */
    public void setDateCreation(Date paramDateCreation) {
        dateCreation = paramDateCreation;
    }
    /**
     * @return the conducteurIdUser
     */
    public int getConducteurIdUser() {
        return conducteurIdUser;
    }
    /**
     * @param paramConducteurIdUser the conducteurIdUser to set
     */
    public void setConducteurIdUser(int paramConducteurIdUser) {
        conducteurIdUser = paramConducteurIdUser;
    }
    /**
     * @return the dateDepart
     */
    public Date getDateDepart() {
        return dateDepart;
    }
    /**
     * @param paramDateDepart the dateDepart to set
     */
    public void setDateDepart(Date paramDateDepart) {
        dateDepart = paramDateDepart;
    }
    /**
     * @return the villeDepart
     */
    public String getVilleDepart() {
        return villeDepart;
    }
    /**
     * @param paramVilleDepart the villeDepart to set
     */
    public void setVilleDepart(String paramVilleDepart) {
        villeDepart = paramVilleDepart;
    }
    /**
     * @return the villeArrivee
     */
    public String getVilleArrivee() {
        return villeArrivee;
    }
    /**
     * @param paramVilleArrivee the villeArrivee to set
     */
    public void setVilleArrivee(String paramVilleArrivee) {
        villeArrivee = paramVilleArrivee;
    }
    /**
     * @return the nbPassagersMax
     */
    public int getNbPassagersMax() {
        return nbPassagersMax;
    }
    /**
     * @param paramNbPassagersMax the nbPassagersMax to set
     */
    public void setNbPassagersMax(int paramNbPassagersMax) {
        nbPassagersMax = paramNbPassagersMax;
    }
    /**
     * @return the nbPassagersRestant
     */
    public int getNbPassagersRestant() {
        return nbPassagersRestant;
    }
    /**
     * @param paramNbPassagersRestant the nbPassagersRestant to set
     */
    public void setNbPassagersRestant(int paramNbPassagersRestant) {
        nbPassagersRestant = paramNbPassagersRestant;
    }
    /**
     * @return the tarif
     */
    public Integer getTarif() {
        return tarif;
    }
    /**
     * @param paramTarif the tarif to set
     */
    public void setTarif(Integer paramTarif) {
        tarif = paramTarif;
    }
    /**
     * @return the statut
     */
    public String getStatut() {
        return statut;
    }
    /**
     * @param paramStatut the statut to set
     */
    public void setStatut(String paramStatut) {
        statut = paramStatut;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TrajetDto [idTrajet=" + idTrajet + ", dateCreation="
                + dateCreation + ", conducteurIdUser=" + conducteurIdUser
                + ", dateDepart=" + dateDepart + ", villeDepart=" + villeDepart
                + ", villeArrivee=" + villeArrivee + ", nbPassagersMax="
                + nbPassagersMax + ", nbPassagersRestant=" + nbPassagersRestant
                + ", tarif=" + tarif + ", statut=" + statut + "]";
    }
    
    
    
}
