
package fr.afcepf.atod21.covoiturage.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for trajetDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="trajetDto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="conducteurIdUser" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dateCreation" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dateDepart" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="idTrajet" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nbPassagersMax" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nbPassagersRestant" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="statut" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tarif" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="villeArrivee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="villeDepart" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trajetDto", propOrder = {
    "conducteurIdUser",
    "dateCreation",
    "dateDepart",
    "idTrajet",
    "nbPassagersMax",
    "nbPassagersRestant",
    "statut",
    "tarif",
    "villeArrivee",
    "villeDepart"
})
public class TrajetDto {

    protected int conducteurIdUser;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateCreation;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateDepart;
    protected int idTrajet;
    protected int nbPassagersMax;
    protected int nbPassagersRestant;
    protected String statut;
    protected Integer tarif;
    protected String villeArrivee;
    protected String villeDepart;

    /**
     * Gets the value of the conducteurIdUser property.
     * 
     */
    public int getConducteurIdUser() {
        return conducteurIdUser;
    }

    /**
     * Sets the value of the conducteurIdUser property.
     * 
     */
    public void setConducteurIdUser(int value) {
        this.conducteurIdUser = value;
    }

    /**
     * Gets the value of the dateCreation property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateCreation() {
        return dateCreation;
    }

    /**
     * Sets the value of the dateCreation property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateCreation(XMLGregorianCalendar value) {
        this.dateCreation = value;
    }

    /**
     * Gets the value of the dateDepart property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateDepart() {
        return dateDepart;
    }

    /**
     * Sets the value of the dateDepart property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateDepart(XMLGregorianCalendar value) {
        this.dateDepart = value;
    }

    /**
     * Gets the value of the idTrajet property.
     * 
     */
    public int getIdTrajet() {
        return idTrajet;
    }

    /**
     * Sets the value of the idTrajet property.
     * 
     */
    public void setIdTrajet(int value) {
        this.idTrajet = value;
    }

    /**
     * Gets the value of the nbPassagersMax property.
     * 
     */
    public int getNbPassagersMax() {
        return nbPassagersMax;
    }

    /**
     * Sets the value of the nbPassagersMax property.
     * 
     */
    public void setNbPassagersMax(int value) {
        this.nbPassagersMax = value;
    }

    /**
     * Gets the value of the nbPassagersRestant property.
     * 
     */
    public int getNbPassagersRestant() {
        return nbPassagersRestant;
    }

    /**
     * Sets the value of the nbPassagersRestant property.
     * 
     */
    public void setNbPassagersRestant(int value) {
        this.nbPassagersRestant = value;
    }

    /**
     * Gets the value of the statut property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatut() {
        return statut;
    }

    /**
     * Sets the value of the statut property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatut(String value) {
        this.statut = value;
    }

    /**
     * Gets the value of the tarif property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTarif() {
        return tarif;
    }

    /**
     * Sets the value of the tarif property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTarif(Integer value) {
        this.tarif = value;
    }

    /**
     * Gets the value of the villeArrivee property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVilleArrivee() {
        return villeArrivee;
    }

    /**
     * Sets the value of the villeArrivee property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVilleArrivee(String value) {
        this.villeArrivee = value;
    }

    /**
     * Gets the value of the villeDepart property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVilleDepart() {
        return villeDepart;
    }

    /**
     * Sets the value of the villeDepart property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVilleDepart(String value) {
        this.villeDepart = value;
    }

}
