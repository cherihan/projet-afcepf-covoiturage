package fr.afcepf.atod21.coVoiturage.business.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CommentaireTrajetDto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int idCommentaireTrajet;
    private String commetaire;
    private int commentaireIdQR;
    private String commentaireTypeQR;
    
    public CommentaireTrajetDto() {
    }


    public CommentaireTrajetDto(int paramIdCommentaireTrajet,
            String paramCommetaire, int paramCommentaireIdQR,
            String paramCommentaireTypeQR) {
        idCommentaireTrajet = paramIdCommentaireTrajet;
        commetaire = paramCommetaire;
        commentaireIdQR = paramCommentaireIdQR;
        commentaireTypeQR = paramCommentaireTypeQR;
    }


    /**
     * @return the idCommentaireTrajet
     */
    public int getIdCommentaireTrajet() {
        return idCommentaireTrajet;
    }


    /**
     * @param paramIdCommentaireTrajet the idCommentaireTrajet to set
     */
    public void setIdCommentaireTrajet(int paramIdCommentaireTrajet) {
        idCommentaireTrajet = paramIdCommentaireTrajet;
    }


    /**
     * @return the commetaire
     */
    public String getCommetaire() {
        return commetaire;
    }


    /**
     * @param paramCommetaire the commetaire to set
     */
    public void setCommetaire(String paramCommetaire) {
        commetaire = paramCommetaire;
    }


    /**
     * @return the commentaireIdQR
     */
    public int getCommentaireIdQR() {
        return commentaireIdQR;
    }


    /**
     * @param paramCommentaireIdQR the commentaireIdQR to set
     */
    public void setCommentaireIdQR(int paramCommentaireIdQR) {
        commentaireIdQR = paramCommentaireIdQR;
    }


    /**
     * @return the commentaireTypeQR
     */
    public String getCommentaireTypeQR() {
        return commentaireTypeQR;
    }


    /**
     * @param paramCommentaireTypeQR the commentaireTypeQR to set
     */
    public void setCommentaireTypeQR(String paramCommentaireTypeQR) {
        commentaireTypeQR = paramCommentaireTypeQR;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CommentaireTrajetDto [idCommentaireTrajet="
                + idCommentaireTrajet + ", commetaire=" + commetaire
                + ", commentaireIdQR=" + commentaireIdQR
                + ", commentaireTypeQR=" + commentaireTypeQR + "]";
    }
    
    
}
