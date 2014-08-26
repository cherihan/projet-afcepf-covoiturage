package fr.afcepf.atod21.coVoiturage.business.dto;

import java.util.Date;

import fr.afcepf.atod21.coVoiturage.entity.Adresse;

public class UtilisateurDto {

    private int idUtilisateur;
    private String civilite;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String telephone;
    private Date dateNaissance;
    private String typeVehicule;
    private String permisConduire;

    private String numeroAdresse;
    private String typeVoieAdresse;
    private String nomVoieAdresse;
    
    private String nomVille;
    private String codePostalVille;
    private String paysVille;
    
    private String porteurCarte;
    private String numCarte;
    private String cryptogrammeCarte;
    private Date dateExpirationCarte;
    /**
     * @return the idUtilisateur
     */
    public int getIdUtilisateur() {
        return idUtilisateur;
    }
    /**
     * @param paramIdUtilisateur the idUtilisateur to set
     */
    public void setIdUtilisateur(int paramIdUtilisateur) {
        idUtilisateur = paramIdUtilisateur;
    }
    /**
     * @return the civilite
     */
    public String getCivilite() {
        return civilite;
    }
    /**
     * @param paramCivilite the civilite to set
     */
    public void setCivilite(String paramCivilite) {
        civilite = paramCivilite;
    }
    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }
    /**
     * @param paramNom the nom to set
     */
    public void setNom(String paramNom) {
        nom = paramNom;
    }
    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }
    /**
     * @param paramPrenom the prenom to set
     */
    public void setPrenom(String paramPrenom) {
        prenom = paramPrenom;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param paramEmail the email to set
     */
    public void setEmail(String paramEmail) {
        email = paramEmail;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param paramPassword the password to set
     */
    public void setPassword(String paramPassword) {
        password = paramPassword;
    }
    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }
    /**
     * @param paramTelephone the telephone to set
     */
    public void setTelephone(String paramTelephone) {
        telephone = paramTelephone;
    }
    /**
     * @return the dateNaissance
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }
    /**
     * @param paramDateNaissance the dateNaissance to set
     */
    public void setDateNaissance(Date paramDateNaissance) {
        dateNaissance = paramDateNaissance;
    }
    /**
     * @return the typeVehicule
     */
    public String getTypeVehicule() {
        return typeVehicule;
    }
    /**
     * @param paramTypeVehicule the typeVehicule to set
     */
    public void setTypeVehicule(String paramTypeVehicule) {
        typeVehicule = paramTypeVehicule;
    }
    /**
     * @return the permisConduire
     */
    public String getPermisConduire() {
        return permisConduire;
    }
    /**
     * @param paramPermisConduire the permisConduire to set
     */
    public void setPermisConduire(String paramPermisConduire) {
        permisConduire = paramPermisConduire;
    }
    /**
     * @return the numeroAdresse
     */
    public String getNumeroAdresse() {
        return numeroAdresse;
    }
    /**
     * @param paramNumeroAdresse the numeroAdresse to set
     */
    public void setNumeroAdresse(String paramNumeroAdresse) {
        numeroAdresse = paramNumeroAdresse;
    }
    /**
     * @return the typeVoieAdresse
     */
    public String getTypeVoieAdresse() {
        return typeVoieAdresse;
    }
    /**
     * @param paramTypeVoieAdresse the typeVoieAdresse to set
     */
    public void setTypeVoieAdresse(String paramTypeVoieAdresse) {
        typeVoieAdresse = paramTypeVoieAdresse;
    }
    /**
     * @return the nomVoieAdresse
     */
    public String getNomVoieAdresse() {
        return nomVoieAdresse;
    }
    /**
     * @param paramNomVoieAdresse the nomVoieAdresse to set
     */
    public void setNomVoieAdresse(String paramNomVoieAdresse) {
        nomVoieAdresse = paramNomVoieAdresse;
    }
    /**
     * @return the nomVille
     */
    public String getNomVille() {
        return nomVille;
    }
    /**
     * @param paramNomVille the nomVille to set
     */
    public void setNomVille(String paramNomVille) {
        nomVille = paramNomVille;
    }
    /**
     * @return the codePostalVille
     */
    public String getCodePostalVille() {
        return codePostalVille;
    }
    /**
     * @param paramCodePostalVille the codePostalVille to set
     */
    public void setCodePostalVille(String paramCodePostalVille) {
        codePostalVille = paramCodePostalVille;
    }
    /**
     * @return the paysVille
     */
    public String getPaysVille() {
        return paysVille;
    }
    /**
     * @param paramPaysVille the paysVille to set
     */
    public void setPaysVille(String paramPaysVille) {
        paysVille = paramPaysVille;
    }
    /**
     * @return the porteurCarte
     */
    public String getPorteurCarte() {
        return porteurCarte;
    }
    /**
     * @param paramPorteurCarte the porteurCarte to set
     */
    public void setPorteurCarte(String paramPorteurCarte) {
        porteurCarte = paramPorteurCarte;
    }

    public String getNumCarte() {
        return numCarte;
    }
    
    public void setNumCarte(String paramNumCarte) {
        numCarte = paramNumCarte;
    }
    /**
     * @return the cryptogrammeCarte
     */
    public String getCryptogrammeCarte() {
        return cryptogrammeCarte;
    }
    /**
     * @param paramCryptogrammeCarte the cryptogrammeCarte to set
     */
    public void setCryptogrammeCarte(String paramCryptogrammeCarte) {
        cryptogrammeCarte = paramCryptogrammeCarte;
    }
    /**
     * @return the dateExpirationCarte
     */
    public Date getDateExpirationCarte() {
        return dateExpirationCarte;
    }
    /**
     * @param paramDateExpirationCarte the dateExpirationCarte to set
     */
    public void setDateExpirationCarte(Date paramDateExpirationCarte) {
        dateExpirationCarte = paramDateExpirationCarte;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "UtilisateurDto [idUtilisateur=" + idUtilisateur + ", civilite="
                + civilite + ", nom=" + nom + ", prenom=" + prenom + ", email="
                + email + ", password=" + password + ", telephone=" + telephone
                + ", dateNaissance=" + dateNaissance + ", typeVehicule="
                + typeVehicule + ", permisConduire=" + permisConduire
                + ", numeroAdresse=" + numeroAdresse + ", typeVoieAdresse="
                + typeVoieAdresse + ", nomVoieAdresse=" + nomVoieAdresse
                + ", nomVille=" + nomVille + ", codePostalVille="
                + codePostalVille + ", paysVille=" + paysVille
                + ", porteurCarte=" + porteurCarte + ", numCarte="
                + numCarte + ", cryptogrammeCarte=" + cryptogrammeCarte
                + ", dateExpirationCarte=" + dateExpirationCarte + "]";
    }
    
    
}
