
package fr.afcepf.atod21.covoiturage.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for utilisateurDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="utilisateurDto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="civilite" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codePostalVille" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateNaissance" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idUtilisateur" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomVille" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomVoieAdresse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroAdresse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paysVille" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="permisConduire" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prenom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telephone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="typeVehicule" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="typeVoieAdresse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "utilisateurDto", propOrder = {
    "civilite",
    "codePostalVille",
    "dateNaissance",
    "email",
    "idUtilisateur",
    "nom",
    "nomVille",
    "nomVoieAdresse",
    "numeroAdresse",
    "password",
    "paysVille",
    "permisConduire",
    "prenom",
    "telephone",
    "typeVehicule",
    "typeVoieAdresse"
})
public class UtilisateurDto {

    protected String civilite;
    protected String codePostalVille;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateNaissance;
    protected String email;
    protected int idUtilisateur;
    protected String nom;
    protected String nomVille;
    protected String nomVoieAdresse;
    protected String numeroAdresse;
    protected String password;
    protected String paysVille;
    protected String permisConduire;
    protected String prenom;
    protected String telephone;
    protected String typeVehicule;
    protected String typeVoieAdresse;

    /**
     * Gets the value of the civilite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCivilite() {
        return civilite;
    }

    /**
     * Sets the value of the civilite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCivilite(String value) {
        this.civilite = value;
    }

    /**
     * Gets the value of the codePostalVille property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodePostalVille() {
        return codePostalVille;
    }

    /**
     * Sets the value of the codePostalVille property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodePostalVille(String value) {
        this.codePostalVille = value;
    }

    /**
     * Gets the value of the dateNaissance property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Sets the value of the dateNaissance property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateNaissance(XMLGregorianCalendar value) {
        this.dateNaissance = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the idUtilisateur property.
     * 
     */
    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    /**
     * Sets the value of the idUtilisateur property.
     * 
     */
    public void setIdUtilisateur(int value) {
        this.idUtilisateur = value;
    }

    /**
     * Gets the value of the nom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets the value of the nom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNom(String value) {
        this.nom = value;
    }

    /**
     * Gets the value of the nomVille property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomVille() {
        return nomVille;
    }

    /**
     * Sets the value of the nomVille property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomVille(String value) {
        this.nomVille = value;
    }

    /**
     * Gets the value of the nomVoieAdresse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomVoieAdresse() {
        return nomVoieAdresse;
    }

    /**
     * Sets the value of the nomVoieAdresse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomVoieAdresse(String value) {
        this.nomVoieAdresse = value;
    }

    /**
     * Gets the value of the numeroAdresse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroAdresse() {
        return numeroAdresse;
    }

    /**
     * Sets the value of the numeroAdresse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroAdresse(String value) {
        this.numeroAdresse = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the paysVille property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaysVille() {
        return paysVille;
    }

    /**
     * Sets the value of the paysVille property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaysVille(String value) {
        this.paysVille = value;
    }

    /**
     * Gets the value of the permisConduire property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPermisConduire() {
        return permisConduire;
    }

    /**
     * Sets the value of the permisConduire property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPermisConduire(String value) {
        this.permisConduire = value;
    }

    /**
     * Gets the value of the prenom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Sets the value of the prenom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrenom(String value) {
        this.prenom = value;
    }

    /**
     * Gets the value of the telephone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Sets the value of the telephone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelephone(String value) {
        this.telephone = value;
    }

    /**
     * Gets the value of the typeVehicule property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeVehicule() {
        return typeVehicule;
    }

    /**
     * Sets the value of the typeVehicule property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeVehicule(String value) {
        this.typeVehicule = value;
    }

    /**
     * Gets the value of the typeVoieAdresse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeVoieAdresse() {
        return typeVoieAdresse;
    }

    /**
     * Sets the value of the typeVoieAdresse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeVoieAdresse(String value) {
        this.typeVoieAdresse = value;
    }

}
