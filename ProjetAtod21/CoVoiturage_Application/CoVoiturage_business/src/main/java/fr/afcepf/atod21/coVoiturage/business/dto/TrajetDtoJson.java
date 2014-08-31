package fr.afcepf.atod21.coVoiturage.business.dto;

import java.io.Serializable;

public class TrajetDtoJson implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int idTrajet;
    private String dateCreationDto;
    private int conducteurIdUser;
    private String dateDepartDto;
    private String villeDepartDto;
    private String villeArriveeDto;
    private int nbPassagersMax;
    private int nbPassagersRestant;
    private int tarif;
    private String statut;
    
    public TrajetDtoJson() {
    }

    public TrajetDtoJson(int paramIdTrajet, String paramDateCreationDto,
            int paramConducteurIdUser, String paramDateDepartDto,
            String paramVilleDepartDto, String paramVilleArriveeDto,
            int paramNbPassagersMax, int paramNbPassagersRestant,
            int paramTarif, String paramStatut) {
        super();
        idTrajet = paramIdTrajet;
        dateCreationDto = paramDateCreationDto;
        conducteurIdUser = paramConducteurIdUser;
        dateDepartDto = paramDateDepartDto;
        villeDepartDto = paramVilleDepartDto;
        villeArriveeDto = paramVilleArriveeDto;
        nbPassagersMax = paramNbPassagersMax;
        nbPassagersRestant = paramNbPassagersRestant;
        tarif = paramTarif;
        statut = paramStatut;
    }




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
    public int getTarif() {
        return tarif;
    }
    /**
     * @param paramTarif the tarif to set
     */
    public void setTarif(int paramTarif) {
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

    /**
     * @return the dateCreationDto
     */
    public String getDateCreationDto() {
        return dateCreationDto;
    }



    /**
     * @param paramDateCreationDto the dateCreationDto to set
     */
    public void setDateCreationDto(String paramDateCreationDto) {
        dateCreationDto = paramDateCreationDto;
    }



    /**
     * @return the dateDepartDto
     */
    public String getDateDepartDto() {
        return dateDepartDto;
    }



    /**
     * @param paramDateDepartDto the dateDepartDto to set
     */
    public void setDateDepartDto(String paramDateDepartDto) {
        dateDepartDto = paramDateDepartDto;
    }



    /**
     * @return the villeDepartDto
     */
    public String getVilleDepartDto() {
        return villeDepartDto;
    }



    /**
     * @param paramVilleDepartDto the villeDepartDto to set
     */
    public void setVilleDepartDto(String paramVilleDepartDto) {
        villeDepartDto = paramVilleDepartDto;
    }



    /**
     * @return the villeArriveeDto
     */
    public String getVilleArriveeDto() {
        return villeArriveeDto;
    }



    /**
     * @param paramVilleArriveeDto the villeArriveeDto to set
     */
    public void setVilleArriveeDto(String paramVilleArriveeDto) {
        villeArriveeDto = paramVilleArriveeDto;
    }

	@Override
	public String toString() {
		return "TrajetDto [idTrajet=" + idTrajet + ", dateCreationDto="
				+ dateCreationDto + ", conducteurIdUser=" + conducteurIdUser
				+ ", dateDepartDto=" + dateDepartDto + ", villeDepartDto="
				+ villeDepartDto + ", villeArriveeDto=" + villeArriveeDto
				+ ", nbPassagersMax=" + nbPassagersMax
				+ ", nbPassagersRestant=" + nbPassagersRestant + ", tarif="
				+ tarif + ", statut=" + statut + "]";
	}

   
}
