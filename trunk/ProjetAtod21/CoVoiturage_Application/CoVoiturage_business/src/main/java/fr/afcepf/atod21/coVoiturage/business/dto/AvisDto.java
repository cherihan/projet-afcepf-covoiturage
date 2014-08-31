package fr.afcepf.atod21.coVoiturage.business.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AvisDto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int idAvis;
    private String contenu;
    private String note;
    
    public AvisDto() {
    }
    
    public AvisDto(int paramIdAvis, String paramContenu, String paramNote) {
        idAvis = paramIdAvis;
        contenu = paramContenu;
        note = paramNote;
    }
    /**
     * @return the idAvis
     */
    public int getIdAvis() {
        return idAvis;
    }
    /**
     * @param paramIdAvis the idAvis to set
     */
    public void setIdAvis(int paramIdAvis) {
        idAvis = paramIdAvis;
    }
    /**
     * @return the contenu
     */
    public String getContenu() {
        return contenu;
    }
    /**
     * @param paramContenu the contenu to set
     */
    public void setContenu(String paramContenu) {
        contenu = paramContenu;
    }
    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }
    /**
     * @param paramNote the note to set
     */
    public void setNote(String paramNote) {
        note = paramNote;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "AvisDto [idAvis=" + idAvis + ", contenu=" + contenu + ", note="
                + note + "]";
    }
    
    
}
